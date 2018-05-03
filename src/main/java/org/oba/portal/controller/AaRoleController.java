package org.oba.portal.controller;

import java.util.List;

import org.oba.portal.base.util.PageableList;
import org.oba.portal.model.AaRole;
import org.oba.portal.service.AaRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/secured/aarole")
@RestController
public class AaRoleController {
    @Autowired
    private AaRoleService serv;

	@GetMapping("/getActiveRoles")
	public List<AaRole> getActiveRoles() throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return serv.getUserRoles(currentPrincipalName);
	}

	/*
	 * CRUD
	 */

    @RequestMapping(value ="/getById/{rid}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLEMAN')")
	public AaRole getById(@PathVariable("rid") Long rid) throws Exception {
		return serv.getModel(rid);
	}

	@PostMapping("/insertModel")
	@PreAuthorize("hasRole('ROLEMAN')")
	public AaRole insertModel(@RequestBody AaRole model) throws Exception {
		return serv.saveModel('c', model);
	}

	@PostMapping("/updateModel")
	@PreAuthorize("hasRole('ROLEMAN')")
	public AaRole updateModel(@RequestBody AaRole model) throws Exception {
		return serv.saveModel('u', model);
	}

	@RequestMapping(value ="/deleteById/{rid}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLEMAN')")
	public boolean deleteById(@PathVariable("rid") Long rid) throws Exception {
		return serv.deleteModel(rid);
	}

	/*
	 * LIST
	 */

	@GetMapping("/getAll")
	@PreAuthorize("hasRole('ROLEMAN')")
	public List<AaRole> getAll() throws Exception {
		return serv.getList();
	}

	@RequestMapping(value ="/getList", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLEMAN')")
	public List<AaRole> getList(@RequestParam(value="srt", required=false) String srt
								, @RequestParam(value="whr", required=false) String whr) throws Exception {
		return serv.getList(srt, whr);
	}

	@RequestMapping(value ="/getPageableList/{pgFirst}/{pgRows}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLEMAN')")
	public PageableList<AaRole> getPageableList(@PathVariable("pgFirst") Integer pgFirst
												, @PathVariable("pgRows") Integer pgRows
												, @RequestParam(value="srt", required=false) String srt
												, @RequestParam(value="whr", required=false) String whr) throws Exception {
		return serv.getPageableList(pgFirst, pgRows, srt, whr);
	}
}
