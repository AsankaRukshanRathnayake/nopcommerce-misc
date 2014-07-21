<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/"> 
 <html>
 <xsl:comment> Author: Dave Edwards </xsl:comment>
 <xsl:comment> Description: Default stylesheet used for reporting all test result information by the Selenium Framework </xsl:comment>
 
 <body>
 <br/>
  <xsl:for-each select="Log">	
	<table border="4" bordercolor="DarkGray" width="100%" bgcolor="WhiteSmoke">
		<tr border="0">
			<td align="center" bgcolor="#000000" height="30"><b><img src="http://docs.seleniumhq.org/images/big-logo.png" height="116" width="137"/></b></td>
		</tr>
		<tr>
			<td>
				<table border="0" width="90%" align="center">
					<tr bgcolor="#919191">
						<th width="15%">Test Run</th>
						<th width="15%">Status</th>
						<th width="15%">Started</th>
						<th width="15%">Ended</th>
						<th width="10%">Total Executed</th>
						<th width="10%">Pass</th>
						<th width="10%">Failed</th>
						<th width="10%">Blocked</th>
					</tr>
					<tr>
						<td><xsl:value-of select="@TestRunID"/></td>
						
						<xsl:choose>
							<xsl:when test="@Status='FAIL'">
								<td align="center"><font color="red"><xsl:value-of select="@Status"/></font></td>		
							</xsl:when>
							<xsl:when test="@Status='PASS'">
								<td align="center"><font color="green"><xsl:value-of select="@Status"/></font></td>		
							</xsl:when>
							<xsl:otherwise>
								<td align="center"><xsl:value-of select="@Status"/></td>		
							</xsl:otherwise>
						</xsl:choose>
						
						<td><xsl:value-of select="@Start"/></td>
						
						<td><xsl:value-of select="@Finish"/></td>

						<td><xsl:value-of select="@TotalNumberExecuted"/></td>

						<td><xsl:value-of select="@TotalPass"/></td>

						<td><xsl:value-of select="@TotalFail"/></td>

						<td><xsl:value-of select="@TotalBlocks"/></td>
					</tr>
				</table>		
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<table border="1" width="100%">
				<xsl:for-each select="TestIteration">
					<tr>
						<td colspan="7" align="center" bgcolor="#919191">
							<b>Test Iteration: <font color="#FFFFFF"><xsl:number value ="position()"/></font>, TestName: <font color="#FFFFFF"><xsl:value-of select="@TestIdentifier"/></font>, Started: <font color="#FFFFFF"><xsl:value-of select="@Start"/></font>, Finished: <font color="#FFFFFF"><xsl:value-of select="@Finish"/></font>, Status =
								<xsl:choose>
									<xsl:when test="@Status='FAIL'">
										<font color="red">FAIL</font>
									</xsl:when>
									<xsl:when test="@Status='PASS'">
										<font color="green">PASS</font>
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="@Status"/>
									</xsl:otherwise>
								</xsl:choose>						
							</b>															
						</td>
					</tr>
					<tr bgcolor="Silver">
						<th width="5%">#</th>
						<th width="10%">Time</th>
						<th width="5%">Status</th>
						<th width="10%">Step Name</th>
					<!--  	<th width="10%">Link</th>-->
						<th width="20%">Expected</th>
						<th width="20%">Actual</th>
						<th width="35%">Details</th>
					</tr>
						<xsl:for-each select="Step">						
						 <tr> 
							<td align="center"><xsl:number value ="position()"/></td>
							<td><xsl:value-of select="Time"/></td>
							<td align="center">
								<xsl:choose>
									<xsl:when test="Status='FAIL'">
										<font color="red">FAIL</font>
									</xsl:when>
									<xsl:when test="Status='PASS'">
										<font color="green">PASS</font>
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="Status"/>
									</xsl:otherwise>
								</xsl:choose>							
							</td>
							<!-- <td><xsl:value-of select="stepName"/></td>
							<a href=\"<xsl:value-of select="Expected">></xsl:value-of><xsl:value-of select="StepName"/></a>-->
							<td><a><xsl:attribute name="href"><xsl:value-of select="Link" /></xsl:attribute><xsl:value-of select="StepName"/></a></td>
							<td><xsl:value-of select="Expected"/></td>
							<td><xsl:value-of select="Actual"/></td>
							<td><xsl:value-of select="Details"/></td>
						</tr>
					</xsl:for-each><!-- Step -->
				
				</xsl:for-each> <!-- Iteration -->				
				</table>
			</td>
		</tr>	
		
	</table>
	<br/><br/>
  </xsl:for-each> <!-- Log -->
 </body>
 </html>


</xsl:template>
</xsl:transform>
