package com.afeka.finalproject.collectionpoints;

/**
 * Created by idoshapira-mbp on 20/05/2018.
 */

public class User {
    public int isAdmin;
    public int pointsCollected;
    public String email;
    public int pointsApproved;
    public int pointsDeclined;


    public User(){
    }

    public User(int isAdmin,int pointsCollected,String email,int pointsApproved,int pointsDeclined){
        this.isAdmin = isAdmin;
        this.pointsCollected = pointsCollected;
        this.email = email;
        this.pointsApproved = pointsApproved;
        this.pointsDeclined = pointsDeclined;
    }


}
