package org.oba.portal.base.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageableList<M> {
   private long totNumOfRecords = 0;
   private List<M> modelList = null;

   public PageableList() {
      // empty
   }

   public PageableList(Page<M> pageableResult) {
      this.totNumOfRecords = pageableResult.getTotalElements();
      if (pageableResult.getContent() == null) {
    	  System.out.println("NULL-NULL-NULL-NULL-NULL-NULL-NULL-NULL-NULL-NULL");
    	  this.modelList = new ArrayList<M>();
      } else
    	  this.modelList = pageableResult.getContent();
   }

   public long getTotNumOfRecords() {
      return totNumOfRecords;
   }

   public void setTotNumOfRecords(long totNumOfRecords) {
      this.totNumOfRecords = totNumOfRecords;
   }

   public List<M> getModelList() {
      return modelList;
   }

   public void setModelList(List<M> list) {
      this.modelList = list;
   }
}
