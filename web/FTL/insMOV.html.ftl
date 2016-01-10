<#include "header.html.ftl">

<#if ESITO??>
    <h1> ${ESITO}</h1>
</#if>


    <h2> Inserimento nuovo Movimento </h2>        
    <form action="servlet/doINS" method="post">
    <h2>Movimento</h2>
    ID<input type="text" name="id"/> <br>
    CODINTEST<select name="codintest" >
		<option value="1001">Lorenzo de carli</option>
		<option value="1002">paolo tomelleri</option>
    </select> <br>

    
    DESCR<input type="text" name="descr" required="required"/> <br>
    CODDEST<input type="text" name="coddest" /> <br>
    IMPORTO<input type="text" name="importo" /> <br>
    DATA<input type="text" name="data" /> <br>

    <input type="submit" value="Submit"/></form>

<#include "footer.html.ftl">
