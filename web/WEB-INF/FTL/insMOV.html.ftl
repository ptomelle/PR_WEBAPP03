<#include "header.html.ftl">



<#if ESITO??><h1>Welcome ${ESITO}!</h1></#if>
    <h2> Inserimento nuovo Movimento </h2>        
    <form action="doINS" method="post">
    <h2>Movimento</h2>
    <input type="text" name="input"/>
    <select name="select" >
		<option value="option 1">option 1</option>
		<option value="option 2">option 2</option>
		<option value="option 3">option 3</option></select>
    
    <input type="text" name="input1" required="required" placeholder="Importo"/>
    <input type="submit" value="Submit"/></form>

<#include "footer.html.ftl">
