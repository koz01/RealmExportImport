/**
 *
 */
package RealmUtil;

import java.io.Serializable;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public interface RealmRepository<T extends RealmObject, ID extends Serializable> {
	T findOne(Realm realm, ID id);

	RealmResults<T> findAll(Realm realm);

	T add(Realm realm, T t);

	T saveOrUpdate(Realm realm, T t);

	List<T> saveOrUpdate(Realm realm, RealmList<T> tList);

	RealmQuery<T> query(Realm realm);

	void delete(Realm realm, ID id);

	void delete(Realm realm, T t);

	void delete(Realm realm, RealmResults<T> realmResults);

	void deleteAll(Realm realm);

	Long getNextId(Realm realm, RealmObject t);

	long count(Realm realm);

	void clear(Realm realm);
}