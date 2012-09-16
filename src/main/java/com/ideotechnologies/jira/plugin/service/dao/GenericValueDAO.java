package com.ideotechnologies.jira.plugin.service.dao;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.module.propertyset.PropertySetManager;

import java.util.HashMap;

/**
 *@
 * @author Ideo Technologies
 *Class allow you to get access to the database
 */
public class GenericValueDAO {
	/**
	 * PropertySet called to get acess with the database
	 * get propertySet or create one if doesn't exist
	 * @param entityId entity id which strore in database
	 * @return PropertySet
	 */
	public  static PropertySet getPS(long entityId) {
		HashMap ofbizArgs = new HashMap();
		ofbizArgs.put("delegator.name", "default");
		ofbizArgs.put("entityName", "CFConfigValue");
		ofbizArgs.put("entityId", new Long(entityId));
		PropertySet ofbizPs = PropertySetManager.getInstance("ofbiz", ofbizArgs);
		return ofbizPs;

	}
	 /**
	  * Set a projectId according to the entity id (configFieldId)
	  * @param configFieldId represent the entity Id
	  * @param value Project Id to set
	  */
	public static void setProjectId(Long configFieldId,Long value){
		PropertySet ps = getPS(configFieldId);
		ps.setLong("projecId", value);
	}
	 /**
	  * Set a issueType Id according to the entity id (configFieldId)
	  * @param configFieldId represent the entity Id
	  * @param value issueType Id to set
	  */
	public static void setIssueTypeId(Long configFieldId,Long value){
		PropertySet ps = getPS(configFieldId);
		ps.setLong("issueTypeId", value);
	}
	 /**
	  * Set a fieldId according to the entity id (configFieldId)
	  * @param configFieldId represent the entity Id
	  * @param value field Id to set
	  */
	public static void setFieldToDisplayId(Long configFieldId,Long value){
		PropertySet ps = getPS(configFieldId);
		ps.setLong("fieldToDisplayId", value);
	}

	public static void setOptionFieldType(Long configFieldId,Long value){
		PropertySet ps = getPS(configFieldId);
		ps.setLong("parentOptionFieldTypeId", value);
	}
	public static void setUrlPrefix(Long configFieldId,String value){
		PropertySet ps = getPS(configFieldId);
		ps.setString("urlPrefix", value);
	}
	
	public static  Long  getProjectId(Long configFieldId) {
		PropertySet	ps = getPS(configFieldId);
		return ps.getLong("projecId");

	}

	public static Long getIssueTypeId(Long configFieldId){
		PropertySet	ps = getPS(configFieldId);
		return ps.getLong("issueTypeId");
	}
	
	public static Long getFieldToDisplayId(Long configFieldId){
		PropertySet	ps = getPS(configFieldId);
		return ps.getLong("fieldToDisplayId");
	}
	public static Long getOptionFieldType(Long configFieldId){
		PropertySet	ps = getPS(configFieldId);
		return ps.getLong("parentOptionFieldTypeId");
	}
	
	public static String getUrlPrefix(Long configFieldId){
		PropertySet	ps = getPS(configFieldId);
		if(!ps.exists("urlPrefix"))return null;
		return ps.getString("urlPrefix");
	}
	
}
