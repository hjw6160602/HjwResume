package com.wj.hr.servlet;

import com.wj.hr.bean.Website;
import com.wj.hr.dao.WebsiteDao;

import javax.servlet.annotation.WebServlet;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/website/*")
public class WebsiteServlet extends BaseServlet {
    private WebsiteDao dao = new WebsiteDao();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Website> websites = dao.list();
        Website website = (websites != null && !websites.isEmpty()) ? websites.get(0) : null;
        request.setAttribute("website", website);
        System.out.println(website.getFooter());
        // 转发
        request.getRequestDispatcher("/page/admin/website.jsp").forward(request, response);
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Website website = new Website();
        BeanUtils.populate(website, request.getParameterMap());
        if (dao.save(website)) {
            // 重定向到admin
            response.sendRedirect(request.getContextPath() + "/website/admin");
        } else {
            // 保存失败
            request.setAttribute("error", "网站信息保存失败");
            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
        }
    }
}
