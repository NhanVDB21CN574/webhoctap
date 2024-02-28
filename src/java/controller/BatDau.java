///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProcessDAO;
import dao.VocabularyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.QuestionVoca;
import model.User;
import model.Vocabulary;
import model.Process;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "BatDau", urlPatterns = {"/batdau"})
public class BatDau extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
        }
        int idu = user.getId();
        int idc = Integer.parseInt(request.getParameter("idc"));
        VocabularyDAO vocabularyDAO = new VocabularyDAO();
        ArrayList<Vocabulary> list = vocabularyDAO.timTatCaTuMoiBangCourse(idc);
        ArrayList<Vocabulary> listVoca = new ArrayList<>();
        ArrayList<String> listOptionV = new ArrayList<>();
        ArrayList<String> listOptionE = new ArrayList<>();
        ProcessDAO processDAO = new ProcessDAO();
        for (Vocabulary v : list) {
            Process process = processDAO.findProcess(idu, v.getId());
            if (process != null) {
                if (process.getProcess() > 0 && process.getProcess() < 1) {
                    listVoca.add(v);
                    listOptionV.add(v.getNghiaTV());
                    listOptionE.add(v.getWord());
                }
            }
        }
        if (listVoca.size() == 0) {
            String error = "Học từ mới trước khi ôn tập!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("batdau.jsp").forward(request, response);
        }
        int sotu = listVoca.size();
        if (sotu > 5) {
            sotu = 5;
        }

        ArrayList<QuestionVoca> listQuestion = new ArrayList<>();
        for (int i = 0; i < sotu; i++) {
            QuestionVoca questionV = new QuestionVoca(1, listVoca.get(i));
            questionV.setOptionV(listOptionV);
            QuestionVoca questionE = new QuestionVoca(2, listVoca.get(i));
            questionE.setOptionE(listOptionE);
            QuestionVoca questionE2 = new QuestionVoca(3, listVoca.get(i));
            questionE2.setOptionE(listOptionE);
            listQuestion.add(questionV);
            listQuestion.add(questionE);
            listQuestion.add(questionE2);
        }
        Collections.shuffle(listQuestion);
        request.setAttribute("idc", idc);
//        request.setAttribute("stt", 0);

        session.setAttribute("listQuestion", listQuestion);
//        request.setAttribute("point", 0);
        request.getRequestDispatcher("ontap?stt=0&point=0").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
