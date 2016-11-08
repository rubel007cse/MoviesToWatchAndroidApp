package com.mrubel.moviestowatch;

/**
 * Created by mosharrofrubel on 11/7/16.
 */
public class DataTemp {

    int _id;
    String _title;
    String _detials;
    String _date;

    public DataTemp(String mytitle, String mydetails, String mydate){
        _title = mytitle;
        _detials = mydetails;
        _date = mydate;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_detials() {
        return _detials;
    }

    public void set_detials(String _detials) {
        this._detials = _detials;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }
}
