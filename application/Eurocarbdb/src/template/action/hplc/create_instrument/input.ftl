<#assign title>Create Instrument</#assign>
<#include "/template/common/header.ftl" />



<h1>Create a new Instrument setting</h1>


<@ww.form>

<table>
<tr><td>Manufacturer:</td><td>
<@ww.textfield  name="manufacturer"/>
</td></tr>
<tr><td>Model:</td><td>
<@ww.textfield  name="model"/>
</td></tr>

<!--
<tr><td>Temperature:</td><td>
<@ww.textfield  name="temperature"/>
</td></tr>
<tr><td>Solvent A:</td><td>
<@ww.textfield  name="solventA"/>
</td></tr>
<tr><td>Solvent B:</td><td>
<@ww.textfield  name="solventB"/>
</td></tr>
-->
<!--<tr><td>Solvent C:</td><td>-->
<@ww.hidden  name="solventC" value="not required"/>
</td></tr>
<!--<tr><td>Solvent D:</td><td>-->

<!--
<@ww.hidden  name="solventD" value="not required"/>
</td></tr>
<tr><td>Flow Rate:</td><td>
<@ww.textfield  name="flowRate"/>
</td></tr>
<tr><td>Flow Gradient:</td><td>
<@ww.textfield  name="flowGradient"/>
</td></tr>	
-->

<tr><td></td>
<td><@ww.submit/>
</td></tr>
</table>
</@ww.form>
<#include "/template/common/footer.ftl" />

