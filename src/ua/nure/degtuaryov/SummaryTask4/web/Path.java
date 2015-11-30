package ua.nure.degtuaryov.SummaryTask4.web;


/**
 * Path constants from my app
 * 
 * @author Degtuaryow
 *
 */
public class Path {
	// pages
	public static final String PAGE_INDEX = "/";
	public static final String PAGE_LOGIN = "/WEB-INF/jsp/user/login.jsp";
	public static final String PAGE_REGISTER = "/WEB-INF/jsp/user/register.jsp";
	public static final String PAGE_ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
	public static final String PAGE_SETTINGS = "/WEB-INF/jsp/client/settings.jsp";
	public static final String PAGE_SHOW_ALL_CLIENTS = "/WEB-INF/jsp/admin/showAllClients.jsp";
	public static final String PAGE_EDIT_CLIENT = "/WEB-INF/jsp/admin/editClient.jsp";
	public static final String PAGE_DELETE_CLIENT = "/WEB-INF/jsp/admin/deleteClient.jsp";
	public static final String PAGE_SHOW_ALL_TRAINS = "/WEB-INF/jsp/admin/showAllTrains.jsp";
	public static final String PAGE_EDIT_TRAIN = "/WEB-INF/jsp/admin/editTrain.jsp";
	public static final String PAGE_ADD_TRAIN = "/WEB-INF/jsp/admin/addTrain.jsp";
	public static final String PAGE_DELETE_TRAIN = "/WEB-INF/jsp/admin/deleteTrain.jsp";
	public static final String PAGE_SHOW_ALL_STATIONS = "/WEB-INF/jsp/admin/showAllStations.jsp";
	public static final String PAGE_SHOW_ALL_ROUTES = "/WEB-INF/jsp/admin/showAllRoutes.jsp";
	public static final String PAGE_SHOW_ALL_STATIONSS_BY_ROUTE_ID = "/WEB-INF/jsp/admin/showAllStationsFromRS.jsp";
	public static final String PAGE_ADD_STATION = "/WEB-INF/jsp/admin/addStation.jsp";
	public static final String PAGE_DELETE_ROUTE = "/WEB-INF/jsp/admin/deleteRoute.jsp";
	public static final String PAGE_ADD_ROUTE = "/WEB-INF/jsp/admin/addRoute.jsp";
	public static final String PAGE_ADD_VOYAGE = "/WEB-INF/jsp/admin/addVoyage.jsp";
	public static final String PAGE_SHOW_ALL_VOYAGES = "/WEB-INF/jsp/admin/showAllVoyages.jsp";
	public static final String PAGE_EDIT_VOYAGE = "/WEB-INF/jsp/admin/editVoyage.jsp";
	public static final String PAGE_TRAINS = "/WEB-INF/jsp/trains.jsp";
	public static final String PAGE_BUY_TICKET = "/WEB-INF/jsp/buyTicket.jsp";
	public static final String PAGE_ALL_TICKETS = "/WEB-INF/jsp/client/showAllTickets.jsp";
	public static final String PAGE_OUN_TICKET = "/WEB-INF/jsp/client/showTicket.jsp";

	// commands
	public static final String COMMAND_VIEW_LOGIN_PAGE = "/controller?command=viewLoginPage";
	public static final String COMMAND_VIEW_REGISTRATION_PAGE = "/controller?command=viewRegisterPage";
	public static final String COMMAND_VIEW_ALL_CLIENTS = "/controller?command=viewAllClients";
	public static final String COMMAND_EDIT_CLIENT = "/controller?command=editClientPage&id=";
	public static final String COMMAND_EDIT_TRAIN = "/controller?command=editTrainPage&id=";
	public static final String COMMAND_VIEW_ALL_TRAINS = "/controller?command=viewAllTrains";
	public static final String COMMAND_VIEW_ALL_ROUTES = "/controller?command=viewAllRoutes";
	public static final String COMMAND_VIEW_ALL_STATIONS = "/controller?command=viewAllStations";
	public static final String COMMAND_VIEW_ADD_TRAIN = "/controller?command=viewAddTrainPage";
	public static final String COMMAND_VIEW_ADD_ROUTE = "/controller?command=viewAddRoutesPage";
	public static final String COMMAND_VIEW_ADD_STATION = "/controller?command=addStationPage";
	public static final String COMMAND_VIEW_ADD_VOYAGE = "/controller?command=viewAddVoyagePage";
	public static final String COMMAND_VIEW_ALL_VOYAGES = "/controller?command=viewAllVoyages";
	public static final String COMMAND_VIEW_EDIT_VOYAGE = "/controller?editVoyagePage&id=";
	public static final String COMMAND_VIEW_FIND_TRAIN = "/controller?command=viewFindTrains";
	public static final String COMMAND_VIEW_SHOW_ALL_TICKETS = "/controller?command=viewTickets";
	public static final String COMMAND_VIEW_SETTINGS = "/controller?command=viewSettings";
}
