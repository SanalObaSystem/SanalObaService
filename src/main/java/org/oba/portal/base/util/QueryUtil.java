package org.oba.portal.base.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public class QueryUtil {

	private static String blockSeperator = "\\|";
	private static String fieldSeperator = "\\;";

	/***************************************************************************************************
	 * SORT 
	 ***************************************************************************************************/

	private static Sort getSortField(String sortFieldInfo) {
		String[] sortField = sortFieldInfo.split(QueryUtil.fieldSeperator);
		if (sortField[0].equals("1")) {
			return new Sort(Sort.Direction.ASC, sortField[1]);
		} else
			if (sortField[0].equals("-1")) {
				return new Sort(Sort.Direction.DESC, sortField[1]);
			} else
				return new Sort(Sort.DEFAULT_DIRECTION, sortFieldInfo);
	}

	public static Sort getSort(String sortInfo) {
		Sort res = null;
		if ((sortInfo != null)
				&& (sortInfo.length() > 1)) {
			String[] sortFields = sortInfo.split(QueryUtil.blockSeperator);
			if ((sortFields != null)
					&& (sortFields.length > 0)) {
				res = QueryUtil.getSortField(sortFields[0]);
				for (int i = 1; i < sortFields.length; i++) {
					res.and(QueryUtil.getSortField(sortFields[i]));
				}
			}
		}
		return res;
	}

	/***************************************************************************************************
	 * WHERE
	 ***************************************************************************************************/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T extends Comparable> Predicate generateParametricPredicate(String matchMode
																				, String fieldName
																				, Class<T> c
																				, T fieldValue
																				, Path<?> p
																				, CriteriaBuilder cb
																				, CriteriaQuery<?> q) {
		Predicate res = null;
		if (matchMode.equals("equals"))
			res = cb.equal(p.get(fieldName), fieldValue);
		else
		if (matchMode.equals("greaterThan"))
			res = cb.greaterThan(p.get(fieldName), fieldValue);
		else
		if (matchMode.equals("lessThan"))
			res = cb.lessThan(p.get(fieldName), fieldValue);
		else
		if (matchMode.equals("greaterOrEqual")) {
			res = cb.greaterThanOrEqualTo(p.get(fieldName), fieldValue);
		} else {
//		if (matchMode.equals("lessOrEqual"))
			res = cb.lessThanOrEqualTo(p.get(fieldName), fieldValue);
		}

		return res;
	}

	private static Predicate generatePredicate(String matchMode
												, String fieldName
												, String fieldValue
												, Path<?> p
												, CriteriaBuilder cb
												, CriteriaQuery<?> q) {
		if (matchMode.equals("startsWith"))
			return cb.like(cb.upper(p.get(fieldName)), fieldValue.toUpperCase() + "%");
		else
			if (matchMode.equals("contains"))
				return cb.like(cb.upper(p.get(fieldName)), "%" + fieldValue.toUpperCase() + "%");
			else
				if (matchMode.equals("endsWith"))
					return cb.like(cb.upper(p.get(fieldName)), fieldValue.toUpperCase() + "%");
				else {
					if (p.get(fieldName).getJavaType() == LocalDateTime.class) {
						ZonedDateTime zdt = ZonedDateTime.parse(fieldValue);
						LocalDateTime filterValue = zdt.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
						return generateParametricPredicate(matchMode, fieldName, LocalDateTime.class, filterValue, p, cb, q);
					} else if (p.get(fieldName).getJavaType() == LocalDate.class) {
						ZonedDateTime zdt = ZonedDateTime.parse(fieldValue);
						LocalDate filterValue = zdt.withZoneSameInstant(ZoneId.systemDefault()).toLocalDate();
						return generateParametricPredicate(matchMode, fieldName, LocalDate.class, filterValue, p, cb, q);
					} else
						if (p.get(fieldName).getJavaType() == Integer.class)
							return generateParametricPredicate(matchMode, fieldName, Integer.class, Integer.valueOf(fieldValue), p, cb, q);
						 else
							if (p.get(fieldName).getJavaType() == Long.class)
								return generateParametricPredicate(matchMode, fieldName, Long.class, Long.valueOf(fieldValue), p, cb, q);
							 else
								if (p.get(fieldName).getJavaType() == Double.class)
									return generateParametricPredicate(matchMode, fieldName, Double.class, Double.valueOf(fieldValue), p, cb, q);
								 else
									if (p.get(fieldName).getJavaType() == Float.class)
										return generateParametricPredicate(matchMode, fieldName, Float.class, Float.valueOf(fieldValue), p, cb, q);
									else
										return generateParametricPredicate(matchMode, fieldName, String.class, fieldValue, p, cb, q);
				}
	}

	/*
	 * IMPORTANT!
	 * 
	 * There is no problem with the usage of join fields (like "aircraft.galley.name" etc.) on the Spring Data's sorting feature.
	 * But Spring data can not handle join fields on Specifications! Developer must use the methods "join" or "fetch" when where conditioning is necessary.
	 * 
	 */
	public static <M> List<Specification<M>> getSpecs(String whereInfo) {
System.out.println("whereInfo");
System.out.println(whereInfo);

		List<Specification<M>> specl = null;

		if ((whereInfo != null)
				&& (whereInfo.length() > 0)) {
			String[] whereFields = whereInfo.split(QueryUtil.blockSeperator);
			if ((whereFields != null)
					&& (whereFields.length > 0)) {

				specl = new ArrayList<Specification<M>>(whereFields.length);
	
				for (int i = 0; i < whereFields.length; i++) {

					if ((whereFields[i] != null)
							&& (whereFields[i].length() > 0)) {
	
						String[] whereField = whereFields[i].split(QueryUtil.fieldSeperator);

						Specification<M> spec = new Specification<M>() {
							@Override
							public Predicate toPredicate(Root<M> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
								int npNdx = whereField[0].indexOf('.');
								if (npNdx > -1) {
									int fpNdx = 0;
									String ffStr = null;
									Path<?> path = root;
									From<?, ?> from = root;
									while (npNdx > -1) {
										ffStr = whereField[0].substring(fpNdx, npNdx);
										fpNdx = npNdx + 1;
										npNdx = whereField[0].indexOf('.', fpNdx);
										from = from.join(ffStr, JoinType.INNER);
										path = path.get(ffStr);
									}
									ffStr = whereField[0].substring(fpNdx, whereField[0].length());
	
									return generatePredicate(whereField[1]
																, ffStr
																, whereField[2]
																, path
																, cb
																, query);
								}
								return generatePredicate(whereField[1]
															, whereField[0]
															, whereField[2]
															, root
															, cb
															, query);
							}
						};
						specl.add(spec);
					}
				}
			}
		}

		return specl;
	}
}
