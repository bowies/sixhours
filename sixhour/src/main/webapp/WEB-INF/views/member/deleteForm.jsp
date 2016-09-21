<%@ page contentType="text/html; charset=UTF-8" %> 
 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 

</head> 
<body>
  
<FORM name='frm' method='POST' action='./delete'>
<input type="hidden" name="mnum" value="${mnum}">

    <input type='submit' value='삭제'>
    <input type='button' value='취소' onclick="history.back()">
    
</FORM>
 
 
<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html> 