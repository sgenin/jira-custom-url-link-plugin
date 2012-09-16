package com.ideotechnologies.jira.plugin.fields.fieldconfig;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.fields.config.FieldConfig;
import com.atlassian.jira.issue.fields.config.FieldConfigItemType;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import com.ideotechnologies.jira.plugin.service.dao.GenericValueDAO;

public class PrefixLinkCFConfig implements FieldConfigItemType {

	@Override
	public String getBaseEditUrl() {
		return "EditPrefixLinkFieldCFConfig.jspa";
	}

	@Override
	public Object getConfigurationObject(Issue arg0, FieldConfig arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayName() {
		return "Context input options";
	}

	@Override
	public String getDisplayNameKey() {
		return "Input options";
	}

	@Override
	public String getObjectKey() {
		// TODO Auto-generated method stub
		return "input-options-prefix-lin";
	}

	@Override
	public String getViewHtml(FieldConfig fieldConfig, FieldLayoutItem arg1) {
		String urlPrefix = GenericValueDAO.getUrlPrefix(fieldConfig.getId());
		if(urlPrefix == null) return "no input value";
		return "<p>Url prefix : "+urlPrefix+" </p>";

	}

}
