package com.ideotechnologies.jira.plugin.fields.customfields;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.impl.TextCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.config.FieldConfig;
import com.atlassian.jira.issue.fields.config.FieldConfigItemType;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import com.ideotechnologies.jira.plugin.fields.fieldconfig.PrefixLinkCFConfig;
import com.ideotechnologies.jira.plugin.service.dao.GenericValueDAO;

import java.util.List;
import java.util.Map;

public class LinkRendererTextCFType extends TextCFType {

	public LinkRendererTextCFType(
			CustomFieldValuePersister customFieldValuePersister,
			GenericConfigManager genericConfigManager) {
		super(customFieldValuePersister, genericConfigManager);
	}

	@Override
	public Object getValueFromIssue(CustomField arg0, Issue arg1) {
		return super.getValueFromIssue(arg0, arg1);
	}

	@Override
	public Map<String, Object> getVelocityParameters(Issue issue,
			CustomField field, FieldLayoutItem fieldLayoutItem) {
		Map<String, Object> velocityParameters = super.getVelocityParameters(issue, field, fieldLayoutItem);
		if(issue == null) return velocityParameters;
		FieldConfig fieldConfig = field.getRelevantConfig(issue);
		if(fieldConfig == null)return velocityParameters; //Resolve anomalies about issue link
		String urlPrefix = GenericValueDAO.getUrlPrefix(fieldConfig.getId());
		velocityParameters.put("urlPrefix", urlPrefix);
		return velocityParameters;
	}
	@Override
	public List getConfigurationItemTypes() {
		final List<FieldConfigItemType> configItemType   = super.getConfigurationItemTypes();
		configItemType.add(new PrefixLinkCFConfig());
		return configItemType;
	}
}
