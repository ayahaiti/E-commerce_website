/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.91
 * Generated at: 2019-04-19 19:14:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class checkProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/taglibs.jsp", Long.valueOf(1554211566349L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Product</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"inc/article.css\">\r\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\r\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header style=\"width:100%;\r\n");
      out.write("\theight:70px;\r\n");
      out.write("\t margin: 0px;\r\n");
      out.write("  padding: 0px;\r\n");
      out.write("\tbackground-color: #696969 ;\">\r\n");
      out.write("\t<h1 style=\"position:absolute;\r\n");
      out.write("\tpadding:3px;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tmargin-left: 2%;\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("\tcolor: white;\">Ebay</h1>\r\n");
      out.write("\t<nav>\r\n");
      out.write("\t<ul style=\"width: auto;\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tmargin-top: 8px;\r\n");
      out.write("\tdisplay: inline-block;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<li style=\"display: inline-block;\r\n");
      out.write("\tpadding: 15px 30px;\"><a style=\"color: white;font-weight: bold;\" href=\"accueil?goTo=accueil\">Home</a></li>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t</nav> </header>\r\n");
      out.write("\t <div class=\"container\">\r\n");
      out.write("        \t<div class=\"row\">\r\n");
      out.write("               <div class=\"col-xs-4 item-photo\">\r\n");
      out.write("                    <img style=\"max-width:100%;\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${image }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-xs-5\" style=\"border:0px solid gray\">\r\n");
      out.write("                    <h3>");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("</h3>    \r\n");
      out.write("                    <h5 style=\"color:#337ab7\">");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("</h5>\r\n");
      out.write("        \r\n");
      out.write("                    <h6 class=\"title-price\"><small>PRIX</small></h6>\r\n");
      out.write("                    <h3 style=\"margin-top:0px;\">");
      if (_jspx_meth_c_005fout_005f2(_jspx_page_context))
        return;
      out.write("</h3>\r\n");
      out.write("        \r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"section\" style=\"padding-bottom:20px;\">\r\n");
      out.write("                        <h6 class=\"title-attr\"><small>Quantité</small></h6>                    \r\n");
      out.write("                        <div>\r\n");
      out.write("                            <div class=\"btn-minus\"><span class=\"glyphicon glyphicon-minus\"></span></div>\r\n");
      out.write("                            <input value=\"1\" />\r\n");
      out.write("                            <div class=\"btn-plus\"><span class=\"glyphicon glyphicon-plus\"></span></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>                \r\n");
      out.write("        \r\n");
      out.write("                    <!-- Botones de compra -->\r\n");
      out.write("                    <div class=\"section\" style=\"padding-bottom:20px;\">\r\n");
      out.write("                        <a class=\"btn btn-success\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\thref=\"accueil?goTo=accueil&add=addtopanier\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span style=\"margin-right:20px\" class=\"glyphicon glyphicon-shopping-cart\" aria-hidden=\"true\"></span> Add to Basket</a>\r\n");
      out.write("                    </div>                                        \r\n");
      out.write("                </div>                              \t\t\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>   \r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("    //-- Click on detail\r\n");
      out.write("    $(\"ul.menu-items > li\").on(\"click\",function(){\r\n");
      out.write("        $(\"ul.menu-items > li\").removeClass(\"active\");\r\n");
      out.write("        $(this).addClass(\"active\");\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    $(\".attr,.attr2\").on(\"click\",function(){\r\n");
      out.write("        var clase = $(this).attr(\"class\");\r\n");
      out.write("\r\n");
      out.write("        $(\".\" + clase).removeClass(\"active\");\r\n");
      out.write("        $(this).addClass(\"active\");\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //-- Click on QUANTITY\r\n");
      out.write("    $(\".btn-minus\").on(\"click\",function(){\r\n");
      out.write("        var now = $(\".section > div > input\").val();\r\n");
      out.write("        if ($.isNumeric(now)){\r\n");
      out.write("            if (parseInt(now) -1 > 0){ now--;}\r\n");
      out.write("            $(\".section > div > input\").val(now);\r\n");
      out.write("        }else{\r\n");
      out.write("            $(\".section > div > input\").val(\"1\");\r\n");
      out.write("        }\r\n");
      out.write("    });           \r\n");
      out.write("    $(\".btn-plus\").on(\"click\",function(){\r\n");
      out.write("        var now = $(\".section > div > input\").val();\r\n");
      out.write("        if ($.isNumeric(now)){\r\n");
      out.write("            $(\".section > div > input\").val(parseInt(now)+1);\r\n");
      out.write("        }else{\r\n");
      out.write("            $(\".section > div > input\").val(\"1\");\r\n");
      out.write("        }\r\n");
      out.write("    });                      \r\n");
      out.write("});\r\n");
      out.write("</script>     \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    boolean _jspx_th_c_005fout_005f0_reused = false;
    try {
      _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fout_005f0.setParent(null);
      // /WEB-INF/checkProduct.jsp(43,24) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
      if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      _jspx_th_c_005fout_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fout_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fout_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    boolean _jspx_th_c_005fout_005f1_reused = false;
    try {
      _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fout_005f1.setParent(null);
      // /WEB-INF/checkProduct.jsp(44,46) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${description }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
      if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      _jspx_th_c_005fout_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fout_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fout_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    boolean _jspx_th_c_005fout_005f2_reused = false;
    try {
      _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fout_005f2.setParent(null);
      // /WEB-INF/checkProduct.jsp(47,48) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prix}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
      if (_jspx_eval_c_005fout_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_c_005fout_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_c_005fout_005f2);
        }
        do {
          out.write(" &#8364;");
          int evalDoAfterBody = _jspx_th_c_005fout_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_c_005fout_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue.reuse(_jspx_th_c_005fout_005f2);
      _jspx_th_c_005fout_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fout_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fout_005f2_reused);
    }
    return false;
  }
}