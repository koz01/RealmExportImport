package com.example.messaging;

import java.util.ArrayList;
import java.util.HashMap;

import RealmUtil.StringRealmRepositoryImpl;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by KZO on 19/07/2016.
 */

public class EmployeeRepoImpl extends StringRealmRepositoryImpl<Employee> implements EmployeeRepo {

    public EmployeeRepoImpl() {

        super(Employee.class);
    }

    @Override
    public ArrayList<Employee> getfindAll(Realm realm) {
        RealmResults<Employee> result;
        ArrayList<Employee> findAlls = new ArrayList<Employee>();
        result = realm.where(Employee.class).findAll();

        if (result.size() > 0) {

            result.sort("id", Sort.ASCENDING);

            try {
                for (Employee loopCust : result) {
                    Employee Employee = new Employee();
                    findAlls.add(populateData(Employee, loopCust));
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return findAlls;
    }

    private static Employee populateData(Employee data,
                                         Employee row) {
        data.setId(row.getId());
        data.setName(row.getName().replace("\"", ""));
        data.setDepartment(row.getDepartment());
        data.setCode(row.getCode());
        return data;
    }
    @Override
    public String getId(Employee employee) {
        return null;
    }

    @Override
    public void setId(Employee employee, String s) {

    }

    @Override
    public long getCount(Realm realm) {
        long count = 0;

        count = realm.where(Employee.class).findAll().size();

        return count;
    }

    @Override
    public ArrayList<HashMap<String, Object>> populateList(ArrayList<Employee> msgList) {
            ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
            for (Employee address : msgList) {
                HashMap<String, Object> temp = new HashMap<String, Object>();
                temp.put("id", address.getId());
                temp.put("Name", address.getName());
                temp.put("Code", address.getCode());
                temp.put("dep", address.getDepartment());
                list.add(temp);
            }
            return list;
    }
}
