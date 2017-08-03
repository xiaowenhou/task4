<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate" flush="true">
	<tiles:putAttribute name="title" type="String" value="前端开发"/>
	<tiles:putAttribute name="body" value="/WEB-INF/tiles/front-body.jsp"/>
</tiles:insertDefinition>
