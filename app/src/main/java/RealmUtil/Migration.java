package RealmUtil;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * Created by KZO on 04/08/2016.
 */

public class Migration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        RealmObjectSchema theSchema = schema.get("RealmStore");
        System.out.println("Realm version is " + oldVersion);
        if (oldVersion == 0) {
            theSchema
                    .addField("username", String.class);
            oldVersion++;
            System.out.println("Realm migrated from 0 to 1");
        }
    }
}
