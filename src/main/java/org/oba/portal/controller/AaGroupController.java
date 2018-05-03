package org.oba.portal.controller;

import java.util.List;

import org.oba.portal.base.util.PageableList;
import org.oba.portal.model.AaGroup;
import org.oba.portal.service.AaGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/secured/aagroup")
@RestController
public class AaGroupController {
    @Autowired
    private AaGroupService serv;

	/*
	 * CRUD
	 */

    @RequestMapping(value ="/getById/{rid}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('GROUPMAN')")
	public AaGroup getById(@PathVariable("rid") Long rid) throws Exception {
		return serv.getModel(rid);
	}

	@PostMapping("/insertModel")
	@PreAuthorize("hasRole('GROUPMAN')")
	public AaGroup insertModel(@RequestBody AaGroup model) throws Exception {
		return serv.saveModel('c', model);
	}

	@PostMapping("/updateModel")
	@PreAuthorize("hasRole('GROUPMAN')")
	public AaGroup updateModel(@RequestBody AaGroup model) throws Exception {
		return serv.saveModel('u', model);
	}

	@RequestMapping(value ="/deleteById/{rid}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('GROUPMAN')")
	public boolean deleteById(@PathVariable("rid") Long rid) throws Exception {
		return serv.deleteModel(rid);
	}

	/*
	 * LIST
	 */

	@GetMapping("/getAll")
	@PreAuthorize("hasRole('GROUPMAN')")
	public List<AaGroup> getAll() throws Exception {
		return serv.getList();
	}

	@RequestMapping(value ="/getList", method = RequestMethod.GET)
	@PreAuthorize("hasRole('GROUPMAN')")
	public List<AaGroup> getList(@RequestParam(value="srt", required=false) String srt
								, @RequestParam(value="whr", required=false) String whr) throws Exception {
		return serv.getList(srt, whr);
	}

	@RequestMapping(value ="/getPageableList/{pgFirst}/{pgRows}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('GROUPMAN')")
	public PageableList<AaGroup> getPageableList(@PathVariable("pgFirst") Integer pgFirst
												, @PathVariable("pgRows") Integer pgRows
												, @RequestParam(value="srt", required=false) String srt
												, @RequestParam(value="whr", required=false) String whr) throws Exception {
		return serv.getPageableList(pgFirst, pgRows, srt, whr);
	}
}
