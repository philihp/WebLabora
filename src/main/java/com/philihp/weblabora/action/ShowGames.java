package com.philihp.weblabora.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.philihp.weblabora.jpa.Game;
import com.philihp.weblabora.jpa.User;

public class ShowGames extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		EntityManager em = (EntityManager)request.getAttribute("em");
		
		TypedQuery<Game> query = em
				.createQuery(
						"SELECT g " +
						"FROM Game g " +
						"WHERE " +
						"     g.players=4 AND" +
						"     (g.player1.user IS NULL " +
						   "OR g.player2.user IS NULL " +
						   "OR g.player3.user IS NULL " +
						   "OR g.player4.user IS NULL)" +
						   "OR" +
						"     g.players=3 AND" +
						"     (g.player1.user IS NULL " +
						   "OR g.player2.user IS NULL " +
						   "OR g.player3.user IS NULL)" +
						   "OR" +
						"     g.players=2 AND" +
						"     (g.player1.user IS NULL " +
						   "OR g.player2.user IS NULL)",
						Game.class);
		List<Game> results = query.getResultList();
		
		request.setAttribute("games", results);

		return mapping.findForward("view");
	}

}
