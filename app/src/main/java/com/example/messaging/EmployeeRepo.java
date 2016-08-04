package com.example.messaging;

import java.util.ArrayList;
import java.util.HashMap;

import RealmUtil.RealmRepository;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by KZO on 19/07/2016.
 */

public interface EmployeeRepo extends RealmRepository<Employee, String> {
    ArrayList<Employee> getfindAll(Realm realm);
    long getCount(Realm realm);
    public ArrayList<HashMap<String, Object>> populateList(ArrayList<Employee> msgList);
}
