package RealmUtil;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by phyo936 on 4/1/16.
 */
public abstract class StringRealmRepositoryImpl<T extends RealmObject> extends BaseRealmRepositoryImpl<T, String>
		implements RealmRepository<T, String> {

	public StringRealmRepositoryImpl(Class<T> clazz) {
		super(clazz);
	}

	@Override
	public T findOne(Realm realm, String id) {
		return query(realm).equalTo("id", id).findFirst();
	}

	@Override
	public void delete(Realm realm, String id) {
		delete(realm, findOne(realm, id));
	}

	@Override
	public Long  getNextId(Realm realm, RealmObject clazz) {

		Long  nextID = realm.where(clazz.getClass()).count();
		if(nextID !=null){
			nextID += 1;
		}else{
			nextID = Long.valueOf(1);
		}

		return nextID;
	}

}
