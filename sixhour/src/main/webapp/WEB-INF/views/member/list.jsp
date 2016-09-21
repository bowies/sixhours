 <%@ page contentType="text/html; charset=UTF-8" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 

<script type="text/javascript">

function create() {
	var url = "../member/create";
	location.href = url;
}
</script>
</head> 
<body> 
 
<DIV class="content"> 

<input type="button" onclick="create()" value="직원 추가">

<FORM method="POST" action="./list">
<select name="col">
<option value="mnum"
<c:if test="${col==mnum}">selected='selected'</c:if>
>직원번호</option>
<option value="mgrade"
<c:if test="${col==mgrade}">selected='selected'</c:if>
>직급</option>
<option value="mname"
  <c:if test="${col==mname}">selected='selected'</c:if>
>이름</option>
<option value="mphone"
  <c:if test="${col==mphone}">selected='selected'</c:if>
>전화번호</option>
<option value="memail"
  <c:if test="${col==memail}">selected='selected'</c:if>
>이메일</option>
</select>
<input type="text" name="word" value="${word}">
<input type="submit" value="검색" />
</FORM>
</DIV>
<A href='total'>직원 목록 다운로드</A>
<c:forEach var="dto" items="${list}">
<TABLE> 
  
  <TR> 
    <TH>직원번호</TH> 
    
    <TD><fmt:formatNumber value="${dto.mnum}" pattern="000"/></TD>
  </TR>
   
  <TR> 
    <TH>직급</TH> 
    <TD>${dto.mgrade}</TD> 
  </TR> 
  <TR> 
    <TH>이름</TH> 
    <TD>${dto.mname}</TD> 
  </TR> 
  <TR> 
    <TH>전화번호</TH> 
    <TD>${dto.mphone}</TD> 
  </TR> 
  <TR> 
    <TH>이메일</TH> 
    <TD>${dto.memail}</TD> 
  </TR> 
   
   <TR>
      <TD><A href='../member/update?mnum=${dto.mnum}'>수정</A></TD>
      　      <TD><A href='../member/delete?mnum=${dto.mnum}'>삭제</A></TD>
 
  </TR>

   
  
</TABLE> 
</c:forEach>
 
</body> 
</html> 