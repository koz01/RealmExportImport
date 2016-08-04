package RealmUtil;

import java.io.Serializable;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by phyo936 on 4/1/16.
 */
public abstract class BaseRealmRepositoryImpl<T extends RealmObject, ID extends Serializable>
        implements RealmRepository<T, ID> {
    protected Class<T> clazz;

    public BaseRealmRepositoryImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public RealmResults<T> findAll(Realm realm) {
        return realm.where(clazz).findAll();
    }

    @Override
    public void clear(Realm realm){
        if (realm.isInTransaction() == false) {
            realm.beginTransaction();
        }
        RealmResults result = realm.where(clazz).findAll();
        result.deleteAllFromRealm();
        realm.delete(clazz);
        realm.commitTransaction();
    }

    @Override
    public T add(Realm realm, T t) {
        return saveOrUpdate(realm, t);
    }

    @Override
    public T saveOrUpdate(Realm realm, T t) {
        T result;
        if (realm.isInTransaction() == false) {
            realm.beginTransaction();
        }
        result = realm.copyToRealmOrUpdate(t);
        realm.commitTransaction();
        return result;
    }

    @Override
    public List<T> saveOrUpdate(Realm realm, RealmList<T> list) {
        List<T> result = null;
        realm.beginTransaction();
        result = realm.copyToRealmOrUpdate(list);
        realm.commitTransaction();
        return result;
    }

    @Override
    public RealmQuery<T> query(Realm realm) {
        return realm.where(clazz);
    }

    @Override
    public void deleteAll(Realm realm) {
        realm.beginTransaction();
        realm.delete(clazz);
        realm.isAutoRefresh();
        realm.commitTransaction();
    }

    @Override
    public void delete(Realm realm, T t) {
        realm.beginTransaction();
        t.deleteFromRealm();
        realm.commitTransaction();
    }

    @Override
    public void delete(Realm realm, RealmResults<T> realmResults) {
        realm.beginTransaction();
        realmResults.deleteAllFromRealm();
        realm.commitTransaction();
    }

    @Override
    public long count(Realm realm) {
        return realm.where(clazz).count();
    }

    public abstract ID getId(T t);

    public abstract void setId(T t, ID id);
}
