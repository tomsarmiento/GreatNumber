package tomassarmiento.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tomassarmiento.web.models.RandomNumber;

/**
 * Servlet implementation class RangeChosen
 */
@WebServlet("/RangeChosen")
public class RangeChosen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RangeChosen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("number")==null) {
			
			int minimum = Integer.parseInt(request.getParameter("minimum"));
			int maximum = Integer.parseInt(request.getParameter("maximum"));
		
			RandomNumber random = new RandomNumber();
			session.setAttribute("number", random.randomNumber(minimum, maximum));
				
			session.setAttribute("minimum", minimum);
			session.setAttribute("maximum", maximum);
			
			int attempts = 3;
			session.setAttribute("attempts",attempts);
		}
		else if(request.getParameter("numberguessed")!=null){
			session.setAttribute("guessednumber", request.getParameter("numberguessed"));
			if(request.getParameter("numberguessed").equals(String.valueOf(session.getAttribute("number")))) {
				String win = "You won!";
				session.setAttribute("winlost", win);
				session.setAttribute("playagain", "Play again!");
			}
			else {
				int newattempts = (int) session.getAttribute("attempts");
				if(newattempts-1==0) {
					String lost = "You lost!";
					session.setAttribute("winlost",lost);
					newattempts--;
					session.setAttribute("attempts", newattempts);
					session.setAttribute("playagain", "Play again!");	
					session.setAttribute("answer", "The answer was: "+session.getAttribute("number"));
				}
				else {
					newattempts--;
					session.setAttribute("attempts", newattempts);
				}

			}
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/guessing.jsp");
	    view.forward(request, response);
	}

}
