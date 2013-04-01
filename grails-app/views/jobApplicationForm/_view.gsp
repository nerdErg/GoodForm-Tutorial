<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder" contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Job Application</title>
</head>

<body>
<div class="goodFormContainer">
  <form:displayText formInstance="${formInstance}" store="${formData}" readOnly="${formInstance.readOnly}"/>
</div>
</body>
</html>
