oracle<%@ page language="java" pageEncoding="GB18030"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for UploadForm form</title>
	</head>
	<body>
	<!-- 批量上传 -->
		<html:form action="/upload" method="post" enctype="multipart/form-data">
		<html:file property="myfile[0]"></html:file><br>	
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

