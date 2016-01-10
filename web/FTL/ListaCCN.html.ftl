<#include "header.html.ftl">

    <h2> Lista Conti Correnti </h2>        
    <table>
                <thead>
                    <td>ID</td>
                    <td>Intestatario</td>
                    <td>Data Apertura</td>
                    <td>Saldo</td>
                </thead>
                <#list CCN as cc>
                    <tr>
                        <#-- valore di default dopo ! -->
                        <td>${cc.id!"0"}</td>
                        <td>${cc.intestatario!""}</td>
                        <td>${cc.dataapertura!"  -  -    "}</td>
                        <td>${cc.saldo!"0"}</td>
                    </tr>
                </#list>           
            </table>
        <br>
<#include "footer.html.ftl">
