
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object searchBookShow extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Book],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(BookList :List[Book]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.24*/(""" 
	"""),format.raw/*2.2*/("""<div id="content">
	
			
		"""),_display_(/*5.4*/if(!BookList.isEmpty())/*5.27*/ {_display_(Seq[Any](format.raw/*5.29*/("""
	
		"""),format.raw/*7.3*/("""<script type="text/javascript">
						$(function() """),format.raw/*8.20*/("""{"""),format.raw/*8.21*/("""
						  """),format.raw/*9.9*/("""$('#buchbox').modal("show")
						"""),format.raw/*10.7*/("""}"""),format.raw/*10.8*/(""");
						
					</script>
			"""),_display_(/*13.5*/for(book <- BookList) yield /*13.26*/{_display_(Seq[Any](format.raw/*13.27*/(""" 
		
			"""),format.raw/*15.4*/("""<div class="buchbox">
				<img class="buchbild" src="""),_display_(/*16.32*/routes/*16.38*/.Assets.at( "images/bucheinzel.jpg")),format.raw/*16.74*/(""" """),format.raw/*16.75*/("""/>
				<p class="buchtitel">Buchtitiel: """),_display_(/*17.39*/book/*17.43*/.getBookName()),format.raw/*17.57*/(""":</p>
				<p class="buchtitel">Autor: """),_display_(/*18.34*/book/*18.38*/.getAuther()),format.raw/*18.50*/("""</p>
				<p class="buchtitel">ISBN: """),_display_(/*19.33*/book/*19.37*/.getISBN()),format.raw/*19.47*/("""</p>
				<p class="buchtitel">Preis: """),_display_(/*20.34*/book/*20.38*/.getPrice()),format.raw/*20.49*/("""</p>
				<a href="""),_display_(/*21.14*/routes/*21.20*/.Application.buyBook(book.getId())),format.raw/*21.54*/("""><img
					class="deleteBook" src="""),_display_(/*22.30*/routes/*22.36*/.Assets.at( "images/shopping.png")),format.raw/*22.70*/("""/></a>
			</div>
			""")))}),format.raw/*24.5*/("""
		""")))}),format.raw/*25.4*/("""
	"""),format.raw/*26.2*/("""</div>
"""))}
  }

  def render(BookList:List[Book]): play.twirl.api.HtmlFormat.Appendable = apply(BookList)

  def f:((List[Book]) => play.twirl.api.HtmlFormat.Appendable) = (BookList) => apply(BookList)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jan 15 18:56:03 CET 2015
                  SOURCE: C:/Users/Fabian/Documents/WebTech/buechern/app/views/searchBookShow.scala.html
                  HASH: a84753247536ecc59864a4c92b861da7efe7f8ab
                  MATRIX: 736->1|846->23|876->27|932->58|963->81|1002->83|1035->90|1114->142|1142->143|1178->153|1240->188|1268->189|1326->221|1363->242|1402->243|1439->253|1520->307|1535->313|1592->349|1621->350|1690->392|1703->396|1738->410|1805->450|1818->454|1851->466|1916->504|1929->508|1960->518|2026->557|2039->561|2071->572|2117->591|2132->597|2187->631|2250->667|2265->673|2320->707|2373->730|2408->735|2438->738
                  LINES: 26->1|29->1|30->2|33->5|33->5|33->5|35->7|36->8|36->8|37->9|38->10|38->10|41->13|41->13|41->13|43->15|44->16|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|52->24|53->25|54->26
                  -- GENERATED --
              */
          