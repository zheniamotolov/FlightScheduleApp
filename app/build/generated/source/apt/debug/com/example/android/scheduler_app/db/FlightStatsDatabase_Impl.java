package com.example.android.scheduler_app.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import com.example.android.scheduler_app.db.dao.AirportDao;
import com.example.android.scheduler_app.db.dao.AirportDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import javax.annotation.Generated;

@Generated("android.arch.persistence.room.RoomProcessor")
@SuppressWarnings("unchecked")
public class FlightStatsDatabase_Impl extends FlightStatsDatabase {
  private volatile AirportDao _airportDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `airport` (`fs` TEXT NOT NULL, `faa` TEXT, `name` TEXT, `city` TEXT, `stateCode` TEXT, `countryCode` TEXT, `countryName` TEXT, `regionName` TEXT, `timeZoneRegionName` TEXT, `localTime` TEXT, `utcOffsetHours` INTEGER, `latitude` REAL, `longitude` REAL, `elevationFeet` INTEGER, `classification` INTEGER, `active` INTEGER, `weatherUrl` TEXT, `delayIndexUrl` TEXT, PRIMARY KEY(`fs`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"7174553d8679384c358530ea049b2570\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `airport`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAirport = new HashMap<String, TableInfo.Column>(18);
        _columnsAirport.put("fs", new TableInfo.Column("fs", "TEXT", true, 1));
        _columnsAirport.put("faa", new TableInfo.Column("faa", "TEXT", false, 0));
        _columnsAirport.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsAirport.put("city", new TableInfo.Column("city", "TEXT", false, 0));
        _columnsAirport.put("stateCode", new TableInfo.Column("stateCode", "TEXT", false, 0));
        _columnsAirport.put("countryCode", new TableInfo.Column("countryCode", "TEXT", false, 0));
        _columnsAirport.put("countryName", new TableInfo.Column("countryName", "TEXT", false, 0));
        _columnsAirport.put("regionName", new TableInfo.Column("regionName", "TEXT", false, 0));
        _columnsAirport.put("timeZoneRegionName", new TableInfo.Column("timeZoneRegionName", "TEXT", false, 0));
        _columnsAirport.put("localTime", new TableInfo.Column("localTime", "TEXT", false, 0));
        _columnsAirport.put("utcOffsetHours", new TableInfo.Column("utcOffsetHours", "INTEGER", false, 0));
        _columnsAirport.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0));
        _columnsAirport.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0));
        _columnsAirport.put("elevationFeet", new TableInfo.Column("elevationFeet", "INTEGER", false, 0));
        _columnsAirport.put("classification", new TableInfo.Column("classification", "INTEGER", false, 0));
        _columnsAirport.put("active", new TableInfo.Column("active", "INTEGER", false, 0));
        _columnsAirport.put("weatherUrl", new TableInfo.Column("weatherUrl", "TEXT", false, 0));
        _columnsAirport.put("delayIndexUrl", new TableInfo.Column("delayIndexUrl", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAirport = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAirport = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAirport = new TableInfo("airport", _columnsAirport, _foreignKeysAirport, _indicesAirport);
        final TableInfo _existingAirport = TableInfo.read(_db, "airport");
        if (! _infoAirport.equals(_existingAirport)) {
          throw new IllegalStateException("Migration didn't properly handle airport(com.example.android.scheduler_app.db.entity.Airport).\n"
                  + " Expected:\n" + _infoAirport + "\n"
                  + " Found:\n" + _existingAirport);
        }
      }
    }, "7174553d8679384c358530ea049b2570", "58d7798a628880aa6e0c4c0d21701770");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "airport");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `airport`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public AirportDao airportDao() {
    if (_airportDao != null) {
      return _airportDao;
    } else {
      synchronized(this) {
        if(_airportDao == null) {
          _airportDao = new AirportDao_Impl(this);
        }
        return _airportDao;
      }
    }
  }
}
