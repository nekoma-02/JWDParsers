<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<body>
<form action="Controller" method="post">
<input type="text" hidden="true" name="command" value="parse">
<input type="submit" name="type_parse" value="SAX">
<input type="submit" name="type_parse" value="STAX">
<input type="submit" name="type_parse" value="DOM">
</form>

</body>
</html>
