package com.taxiservicespring.util.constant;

public interface WebPage {
    String MAIN_PAGE = "/index";
    String ERROR_PAGE = "/error";

    // common pages
    String LOGIN_PAGE = "/common/login";

    // client pages
    String SIGNUP_PAGE = "/client/signUp";
    String NEW_ORDER_PAGE = "/client/newOrder";
    String CUSTOMER_ACCOUNT_PAGE = "/client/clientAccount";
    String CAR_INFO_PAGE = "/client/carInformation";
    String ALTERNATIVE_ORDER_PAGE = "/client/alternativeOrder";
    String SUCCESSFUL_ORDER_PAGE = "/client/successfulOrder";

    //admin pages
    String ADMIN_ACCOUNT_PAGE = "/admin/adminAccount";
    String AUTO_PARK_PAGE = "/admin/autoPark";
    String ORDER_CARS_PAGE = "/admin/carsInOrderInformation";
}
