package dao;

public class DaoFactory {
    private static dao.Ads adsDao;
    private static Users usersDao;
    private static dao.Config config = new dao.Config();

    public static dao.Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
