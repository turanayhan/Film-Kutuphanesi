package com.example.filmkutuphanesi.Database;

import android.content.Context;

public class SessionManager {
    private static SessionManager instance;
    private SQLiteManager sqliteManager;

    private SessionManager(Context context) {
        sqliteManager = SQLiteManager.getInstance(context);
    }

    public static synchronized SessionManager getInstance(Context context) {
        if (instance == null) {
            instance = new SessionManager(context.getApplicationContext());
        }
        return instance;
    }

    public boolean login(String username, String password) {
        boolean isUserValid = sqliteManager.checkUser(username, password);
        if (isUserValid) {

            sqliteManager.updateLoginStatus(username, true);
        }
        return isUserValid;
    }

    public void register(String username, String password) {
        sqliteManager.addUser(username, password);
    }

    public boolean isLoggedIn() {
        return sqliteManager.checkUserLoggedIn();
    }

    public void logout() {
        sqliteManager.logoutUser();
    }
}
