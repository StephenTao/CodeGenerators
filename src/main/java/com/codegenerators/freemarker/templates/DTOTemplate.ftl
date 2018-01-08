package ${packageName}

uses edge.jsonmapper.JsonProperty
<#if true>
uses edge.jsonmapper.Required
</#if>
uses java.lang.Integer

/**
 * Created with Code Generators.
 * User: ${createUser}
 * Date: ${createDate}
 * Time: ${createTime}
 <#if comment?has_content>
 * ${comment}
 <#else>
 * To change this template use File | Settings | File Templates.
 </#if>
 */
class ${className} {

    <#list properties as property>
    <#if property.comment?has_content>
    //${property.comment}
    </#if>
    @JsonProperty
    <#if property.requried == true>
    @Required
    </#if>
    var _${property.propertyID} : ${property.type} as ${property.name}
    
    </#list>
}