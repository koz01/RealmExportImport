package RealmUtil;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import java.io.File;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author Naw Zar
 *
 */
public class RealmConfigSetting extends Application{
	private Context context;
	
	public RealmConfigSetting(Context context) {
		this.context = context;
	}
	
	public void RealmConfigSetting() {

		RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(Environment.getExternalStorageDirectory())
				.name("tablet-sale.realm")
				.schemaVersion(9)
				.deleteRealmIfMigrationNeeded()
				.migration(new Migration())
				.build();
		Realm.compactRealm(realmConfiguration);
        Realm.setDefaultConfiguration(realmConfiguration);

	}
}
