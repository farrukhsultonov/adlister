package dao;

import models.Ad;

import java.util.ArrayList;
import java.util.List;

public abstract class ListAdsDao implements dao.Ads {
    private List<Ad> ads;

    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    public Long insert(Ad ad) {
        // make sure we have ads
        if (ads == null) {
            ads = generateAds();
        }

        ad.setId((long) ads.size());
        ads.add(ad);
        return ad.getId();
    }

    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
                1,
                1,
                "ps5 for sale",
                "This is a slightly used playstation"
        ));
        ads.add(new Ad(
                2,
                1,
                "Super Nintendo",
                "Like new, game-on!"
        ));
        ads.add(new Ad(
                3,
                2,
                "Junior Java Developer Position",
                "Pays 500k"
        ));
        ads.add(new Ad(
                4,
                2,
                "JavaScript Developer needed",
                "React, HTML, CSS"
        ));
        return ads;
    }
}
