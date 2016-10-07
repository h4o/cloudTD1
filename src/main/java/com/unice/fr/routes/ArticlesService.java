package com.unice.fr.routes;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.GsonBuilder;
import com.unice.fr.entities.Article;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 07/10/16.
 */
public class ArticlesService extends HttpServlet {
    private List<Article> articleList = new ArrayList<>();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        response.setContentType("application/json");
        response.getWriter().println(gson.toJson(articleList));

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            response.setContentType("application/json");
            response.getWriter().println("ERRROORORORO");
        }
        String res = jb.toString();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Article a = gson.fromJson(res, Article.class);
        articleList.add(a);
        response.setContentType("application/json");
        response.getWriter().println(res);
    }



}
