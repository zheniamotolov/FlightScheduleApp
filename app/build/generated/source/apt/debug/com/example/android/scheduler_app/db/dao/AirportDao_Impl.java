package com.example.android.scheduler_app.db.dao;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.example.android.scheduler_app.db.entity.Airport;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;

@Generated("android.arch.persistence.room.RoomProcessor")
@SuppressWarnings("unchecked")
public class AirportDao_Impl implements AirportDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAirport;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAirport;

  public AirportDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAirport = new EntityInsertionAdapter<Airport>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `airport`(`fs`,`iata`,`icao`,`faa`,`name`,`street1`,`street2`,`city`,`cityCode`,`stateCode`,`postalCode`,`countryCode`,`district`,`countryName`,`regionName`,`timeZoneRegionName`,`weatherZone`,`localTime`,`utcOffsetHours`,`latitude`,`longitude`,`elevationFeet`,`classification`,`active`,`dateFrom`,`dateTo`,`weatherUrl`,`delayIndexUrl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Airport value) {
        if (value.getFs() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getFs());
        }
        if (value.getIata() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIata());
        }
        if (value.getIcao() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIcao());
        }
        if (value.getFaa() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFaa());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getStreet1() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStreet1());
        }
        if (value.getStreet2() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getStreet2());
        }
        if (value.getCity() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCity());
        }
        if (value.getCityCode() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCityCode());
        }
        if (value.getStateCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStateCode());
        }
        if (value.getPostalCode() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPostalCode());
        }
        if (value.getCountryCode() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCountryCode());
        }
        if (value.getDistrict() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDistrict());
        }
        if (value.getCountryName() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getCountryName());
        }
        if (value.getRegionName() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRegionName());
        }
        if (value.getTimeZoneRegionName() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTimeZoneRegionName());
        }
        if (value.getWeatherZone() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getWeatherZone());
        }
        if (value.getLocalTime() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getLocalTime());
        }
        stmt.bindDouble(19, value.getUtcOffsetHours());
        stmt.bindDouble(20, value.getLatitude());
        stmt.bindDouble(21, value.getLongitude());
        stmt.bindLong(22, value.getElevationFeet());
        stmt.bindLong(23, value.getClassification());
        final int _tmp;
        _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(24, _tmp);
        if (value.getDateFrom() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getDateFrom());
        }
        if (value.getDateTo() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getDateTo());
        }
        if (value.getWeatherUrl() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getWeatherUrl());
        }
        if (value.getDelayIndexUrl() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getDelayIndexUrl());
        }
      }
    };
    this.__deletionAdapterOfAirport = new EntityDeletionOrUpdateAdapter<Airport>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `airport` WHERE `fs` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Airport value) {
        if (value.getFs() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getFs());
        }
      }
    };
  }

  @Override
  public void insertAirports(List<Airport> airports) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAirport.insert(airports);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAirport(Airport airport) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAirport.insert(airport);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Airport airport) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAirport.handle(airport);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Airport>> getAllAirportsItems() {
    final String _sql = "SELECT * FROM Airport";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Airport>>() {
      private Observer _observer;

      @Override
      protected List<Airport> compute() {
        if (_observer == null) {
          _observer = new Observer("Airport") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfFs = _cursor.getColumnIndexOrThrow("fs");
          final int _cursorIndexOfIata = _cursor.getColumnIndexOrThrow("iata");
          final int _cursorIndexOfIcao = _cursor.getColumnIndexOrThrow("icao");
          final int _cursorIndexOfFaa = _cursor.getColumnIndexOrThrow("faa");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfStreet1 = _cursor.getColumnIndexOrThrow("street1");
          final int _cursorIndexOfStreet2 = _cursor.getColumnIndexOrThrow("street2");
          final int _cursorIndexOfCity = _cursor.getColumnIndexOrThrow("city");
          final int _cursorIndexOfCityCode = _cursor.getColumnIndexOrThrow("cityCode");
          final int _cursorIndexOfStateCode = _cursor.getColumnIndexOrThrow("stateCode");
          final int _cursorIndexOfPostalCode = _cursor.getColumnIndexOrThrow("postalCode");
          final int _cursorIndexOfCountryCode = _cursor.getColumnIndexOrThrow("countryCode");
          final int _cursorIndexOfDistrict = _cursor.getColumnIndexOrThrow("district");
          final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
          final int _cursorIndexOfRegionName = _cursor.getColumnIndexOrThrow("regionName");
          final int _cursorIndexOfTimeZoneRegionName = _cursor.getColumnIndexOrThrow("timeZoneRegionName");
          final int _cursorIndexOfWeatherZone = _cursor.getColumnIndexOrThrow("weatherZone");
          final int _cursorIndexOfLocalTime = _cursor.getColumnIndexOrThrow("localTime");
          final int _cursorIndexOfUtcOffsetHours = _cursor.getColumnIndexOrThrow("utcOffsetHours");
          final int _cursorIndexOfLatitude = _cursor.getColumnIndexOrThrow("latitude");
          final int _cursorIndexOfLongitude = _cursor.getColumnIndexOrThrow("longitude");
          final int _cursorIndexOfElevationFeet = _cursor.getColumnIndexOrThrow("elevationFeet");
          final int _cursorIndexOfClassification = _cursor.getColumnIndexOrThrow("classification");
          final int _cursorIndexOfActive = _cursor.getColumnIndexOrThrow("active");
          final int _cursorIndexOfDateFrom = _cursor.getColumnIndexOrThrow("dateFrom");
          final int _cursorIndexOfDateTo = _cursor.getColumnIndexOrThrow("dateTo");
          final int _cursorIndexOfWeatherUrl = _cursor.getColumnIndexOrThrow("weatherUrl");
          final int _cursorIndexOfDelayIndexUrl = _cursor.getColumnIndexOrThrow("delayIndexUrl");
          final List<Airport> _result = new ArrayList<Airport>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Airport _item;
            _item = new Airport();
            final String _tmpFs;
            _tmpFs = _cursor.getString(_cursorIndexOfFs);
            _item.setFs(_tmpFs);
            final String _tmpIata;
            _tmpIata = _cursor.getString(_cursorIndexOfIata);
            _item.setIata(_tmpIata);
            final String _tmpIcao;
            _tmpIcao = _cursor.getString(_cursorIndexOfIcao);
            _item.setIcao(_tmpIcao);
            final String _tmpFaa;
            _tmpFaa = _cursor.getString(_cursorIndexOfFaa);
            _item.setFaa(_tmpFaa);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpStreet1;
            _tmpStreet1 = _cursor.getString(_cursorIndexOfStreet1);
            _item.setStreet1(_tmpStreet1);
            final String _tmpStreet2;
            _tmpStreet2 = _cursor.getString(_cursorIndexOfStreet2);
            _item.setStreet2(_tmpStreet2);
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            _item.setCity(_tmpCity);
            final String _tmpCityCode;
            _tmpCityCode = _cursor.getString(_cursorIndexOfCityCode);
            _item.setCityCode(_tmpCityCode);
            final String _tmpStateCode;
            _tmpStateCode = _cursor.getString(_cursorIndexOfStateCode);
            _item.setStateCode(_tmpStateCode);
            final String _tmpPostalCode;
            _tmpPostalCode = _cursor.getString(_cursorIndexOfPostalCode);
            _item.setPostalCode(_tmpPostalCode);
            final String _tmpCountryCode;
            _tmpCountryCode = _cursor.getString(_cursorIndexOfCountryCode);
            _item.setCountryCode(_tmpCountryCode);
            final String _tmpDistrict;
            _tmpDistrict = _cursor.getString(_cursorIndexOfDistrict);
            _item.setDistrict(_tmpDistrict);
            final String _tmpCountryName;
            _tmpCountryName = _cursor.getString(_cursorIndexOfCountryName);
            _item.setCountryName(_tmpCountryName);
            final String _tmpRegionName;
            _tmpRegionName = _cursor.getString(_cursorIndexOfRegionName);
            _item.setRegionName(_tmpRegionName);
            final String _tmpTimeZoneRegionName;
            _tmpTimeZoneRegionName = _cursor.getString(_cursorIndexOfTimeZoneRegionName);
            _item.setTimeZoneRegionName(_tmpTimeZoneRegionName);
            final String _tmpWeatherZone;
            _tmpWeatherZone = _cursor.getString(_cursorIndexOfWeatherZone);
            _item.setWeatherZone(_tmpWeatherZone);
            final String _tmpLocalTime;
            _tmpLocalTime = _cursor.getString(_cursorIndexOfLocalTime);
            _item.setLocalTime(_tmpLocalTime);
            final double _tmpUtcOffsetHours;
            _tmpUtcOffsetHours = _cursor.getDouble(_cursorIndexOfUtcOffsetHours);
            _item.setUtcOffsetHours(_tmpUtcOffsetHours);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            _item.setLatitude(_tmpLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            _item.setLongitude(_tmpLongitude);
            final int _tmpElevationFeet;
            _tmpElevationFeet = _cursor.getInt(_cursorIndexOfElevationFeet);
            _item.setElevationFeet(_tmpElevationFeet);
            final int _tmpClassification;
            _tmpClassification = _cursor.getInt(_cursorIndexOfClassification);
            _item.setClassification(_tmpClassification);
            final boolean _tmpActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfActive);
            _tmpActive = _tmp != 0;
            _item.setActive(_tmpActive);
            final String _tmpDateFrom;
            _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
            _item.setDateFrom(_tmpDateFrom);
            final String _tmpDateTo;
            _tmpDateTo = _cursor.getString(_cursorIndexOfDateTo);
            _item.setDateTo(_tmpDateTo);
            final String _tmpWeatherUrl;
            _tmpWeatherUrl = _cursor.getString(_cursorIndexOfWeatherUrl);
            _item.setWeatherUrl(_tmpWeatherUrl);
            final String _tmpDelayIndexUrl;
            _tmpDelayIndexUrl = _cursor.getString(_cursorIndexOfDelayIndexUrl);
            _item.setDelayIndexUrl(_tmpDelayIndexUrl);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<Airport> loadAllById(String airportFs) {
    final String _sql = "SELECT * FROM Airport WHERE fs =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (airportFs == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, airportFs);
    }
    return new ComputableLiveData<Airport>() {
      private Observer _observer;

      @Override
      protected Airport compute() {
        if (_observer == null) {
          _observer = new Observer("Airport") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfFs = _cursor.getColumnIndexOrThrow("fs");
          final int _cursorIndexOfIata = _cursor.getColumnIndexOrThrow("iata");
          final int _cursorIndexOfIcao = _cursor.getColumnIndexOrThrow("icao");
          final int _cursorIndexOfFaa = _cursor.getColumnIndexOrThrow("faa");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfStreet1 = _cursor.getColumnIndexOrThrow("street1");
          final int _cursorIndexOfStreet2 = _cursor.getColumnIndexOrThrow("street2");
          final int _cursorIndexOfCity = _cursor.getColumnIndexOrThrow("city");
          final int _cursorIndexOfCityCode = _cursor.getColumnIndexOrThrow("cityCode");
          final int _cursorIndexOfStateCode = _cursor.getColumnIndexOrThrow("stateCode");
          final int _cursorIndexOfPostalCode = _cursor.getColumnIndexOrThrow("postalCode");
          final int _cursorIndexOfCountryCode = _cursor.getColumnIndexOrThrow("countryCode");
          final int _cursorIndexOfDistrict = _cursor.getColumnIndexOrThrow("district");
          final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
          final int _cursorIndexOfRegionName = _cursor.getColumnIndexOrThrow("regionName");
          final int _cursorIndexOfTimeZoneRegionName = _cursor.getColumnIndexOrThrow("timeZoneRegionName");
          final int _cursorIndexOfWeatherZone = _cursor.getColumnIndexOrThrow("weatherZone");
          final int _cursorIndexOfLocalTime = _cursor.getColumnIndexOrThrow("localTime");
          final int _cursorIndexOfUtcOffsetHours = _cursor.getColumnIndexOrThrow("utcOffsetHours");
          final int _cursorIndexOfLatitude = _cursor.getColumnIndexOrThrow("latitude");
          final int _cursorIndexOfLongitude = _cursor.getColumnIndexOrThrow("longitude");
          final int _cursorIndexOfElevationFeet = _cursor.getColumnIndexOrThrow("elevationFeet");
          final int _cursorIndexOfClassification = _cursor.getColumnIndexOrThrow("classification");
          final int _cursorIndexOfActive = _cursor.getColumnIndexOrThrow("active");
          final int _cursorIndexOfDateFrom = _cursor.getColumnIndexOrThrow("dateFrom");
          final int _cursorIndexOfDateTo = _cursor.getColumnIndexOrThrow("dateTo");
          final int _cursorIndexOfWeatherUrl = _cursor.getColumnIndexOrThrow("weatherUrl");
          final int _cursorIndexOfDelayIndexUrl = _cursor.getColumnIndexOrThrow("delayIndexUrl");
          final Airport _result;
          if(_cursor.moveToFirst()) {
            _result = new Airport();
            final String _tmpFs;
            _tmpFs = _cursor.getString(_cursorIndexOfFs);
            _result.setFs(_tmpFs);
            final String _tmpIata;
            _tmpIata = _cursor.getString(_cursorIndexOfIata);
            _result.setIata(_tmpIata);
            final String _tmpIcao;
            _tmpIcao = _cursor.getString(_cursorIndexOfIcao);
            _result.setIcao(_tmpIcao);
            final String _tmpFaa;
            _tmpFaa = _cursor.getString(_cursorIndexOfFaa);
            _result.setFaa(_tmpFaa);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _result.setName(_tmpName);
            final String _tmpStreet1;
            _tmpStreet1 = _cursor.getString(_cursorIndexOfStreet1);
            _result.setStreet1(_tmpStreet1);
            final String _tmpStreet2;
            _tmpStreet2 = _cursor.getString(_cursorIndexOfStreet2);
            _result.setStreet2(_tmpStreet2);
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            _result.setCity(_tmpCity);
            final String _tmpCityCode;
            _tmpCityCode = _cursor.getString(_cursorIndexOfCityCode);
            _result.setCityCode(_tmpCityCode);
            final String _tmpStateCode;
            _tmpStateCode = _cursor.getString(_cursorIndexOfStateCode);
            _result.setStateCode(_tmpStateCode);
            final String _tmpPostalCode;
            _tmpPostalCode = _cursor.getString(_cursorIndexOfPostalCode);
            _result.setPostalCode(_tmpPostalCode);
            final String _tmpCountryCode;
            _tmpCountryCode = _cursor.getString(_cursorIndexOfCountryCode);
            _result.setCountryCode(_tmpCountryCode);
            final String _tmpDistrict;
            _tmpDistrict = _cursor.getString(_cursorIndexOfDistrict);
            _result.setDistrict(_tmpDistrict);
            final String _tmpCountryName;
            _tmpCountryName = _cursor.getString(_cursorIndexOfCountryName);
            _result.setCountryName(_tmpCountryName);
            final String _tmpRegionName;
            _tmpRegionName = _cursor.getString(_cursorIndexOfRegionName);
            _result.setRegionName(_tmpRegionName);
            final String _tmpTimeZoneRegionName;
            _tmpTimeZoneRegionName = _cursor.getString(_cursorIndexOfTimeZoneRegionName);
            _result.setTimeZoneRegionName(_tmpTimeZoneRegionName);
            final String _tmpWeatherZone;
            _tmpWeatherZone = _cursor.getString(_cursorIndexOfWeatherZone);
            _result.setWeatherZone(_tmpWeatherZone);
            final String _tmpLocalTime;
            _tmpLocalTime = _cursor.getString(_cursorIndexOfLocalTime);
            _result.setLocalTime(_tmpLocalTime);
            final double _tmpUtcOffsetHours;
            _tmpUtcOffsetHours = _cursor.getDouble(_cursorIndexOfUtcOffsetHours);
            _result.setUtcOffsetHours(_tmpUtcOffsetHours);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            _result.setLatitude(_tmpLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            _result.setLongitude(_tmpLongitude);
            final int _tmpElevationFeet;
            _tmpElevationFeet = _cursor.getInt(_cursorIndexOfElevationFeet);
            _result.setElevationFeet(_tmpElevationFeet);
            final int _tmpClassification;
            _tmpClassification = _cursor.getInt(_cursorIndexOfClassification);
            _result.setClassification(_tmpClassification);
            final boolean _tmpActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfActive);
            _tmpActive = _tmp != 0;
            _result.setActive(_tmpActive);
            final String _tmpDateFrom;
            _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
            _result.setDateFrom(_tmpDateFrom);
            final String _tmpDateTo;
            _tmpDateTo = _cursor.getString(_cursorIndexOfDateTo);
            _result.setDateTo(_tmpDateTo);
            final String _tmpWeatherUrl;
            _tmpWeatherUrl = _cursor.getString(_cursorIndexOfWeatherUrl);
            _result.setWeatherUrl(_tmpWeatherUrl);
            final String _tmpDelayIndexUrl;
            _tmpDelayIndexUrl = _cursor.getString(_cursorIndexOfDelayIndexUrl);
            _result.setDelayIndexUrl(_tmpDelayIndexUrl);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<Airport> findByAirportListItemEntityName(String airportName) {
    final String _sql = "SELECT * FROM Airport WHERE name  =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (airportName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, airportName);
    }
    return new ComputableLiveData<Airport>() {
      private Observer _observer;

      @Override
      protected Airport compute() {
        if (_observer == null) {
          _observer = new Observer("Airport") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfFs = _cursor.getColumnIndexOrThrow("fs");
          final int _cursorIndexOfIata = _cursor.getColumnIndexOrThrow("iata");
          final int _cursorIndexOfIcao = _cursor.getColumnIndexOrThrow("icao");
          final int _cursorIndexOfFaa = _cursor.getColumnIndexOrThrow("faa");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfStreet1 = _cursor.getColumnIndexOrThrow("street1");
          final int _cursorIndexOfStreet2 = _cursor.getColumnIndexOrThrow("street2");
          final int _cursorIndexOfCity = _cursor.getColumnIndexOrThrow("city");
          final int _cursorIndexOfCityCode = _cursor.getColumnIndexOrThrow("cityCode");
          final int _cursorIndexOfStateCode = _cursor.getColumnIndexOrThrow("stateCode");
          final int _cursorIndexOfPostalCode = _cursor.getColumnIndexOrThrow("postalCode");
          final int _cursorIndexOfCountryCode = _cursor.getColumnIndexOrThrow("countryCode");
          final int _cursorIndexOfDistrict = _cursor.getColumnIndexOrThrow("district");
          final int _cursorIndexOfCountryName = _cursor.getColumnIndexOrThrow("countryName");
          final int _cursorIndexOfRegionName = _cursor.getColumnIndexOrThrow("regionName");
          final int _cursorIndexOfTimeZoneRegionName = _cursor.getColumnIndexOrThrow("timeZoneRegionName");
          final int _cursorIndexOfWeatherZone = _cursor.getColumnIndexOrThrow("weatherZone");
          final int _cursorIndexOfLocalTime = _cursor.getColumnIndexOrThrow("localTime");
          final int _cursorIndexOfUtcOffsetHours = _cursor.getColumnIndexOrThrow("utcOffsetHours");
          final int _cursorIndexOfLatitude = _cursor.getColumnIndexOrThrow("latitude");
          final int _cursorIndexOfLongitude = _cursor.getColumnIndexOrThrow("longitude");
          final int _cursorIndexOfElevationFeet = _cursor.getColumnIndexOrThrow("elevationFeet");
          final int _cursorIndexOfClassification = _cursor.getColumnIndexOrThrow("classification");
          final int _cursorIndexOfActive = _cursor.getColumnIndexOrThrow("active");
          final int _cursorIndexOfDateFrom = _cursor.getColumnIndexOrThrow("dateFrom");
          final int _cursorIndexOfDateTo = _cursor.getColumnIndexOrThrow("dateTo");
          final int _cursorIndexOfWeatherUrl = _cursor.getColumnIndexOrThrow("weatherUrl");
          final int _cursorIndexOfDelayIndexUrl = _cursor.getColumnIndexOrThrow("delayIndexUrl");
          final Airport _result;
          if(_cursor.moveToFirst()) {
            _result = new Airport();
            final String _tmpFs;
            _tmpFs = _cursor.getString(_cursorIndexOfFs);
            _result.setFs(_tmpFs);
            final String _tmpIata;
            _tmpIata = _cursor.getString(_cursorIndexOfIata);
            _result.setIata(_tmpIata);
            final String _tmpIcao;
            _tmpIcao = _cursor.getString(_cursorIndexOfIcao);
            _result.setIcao(_tmpIcao);
            final String _tmpFaa;
            _tmpFaa = _cursor.getString(_cursorIndexOfFaa);
            _result.setFaa(_tmpFaa);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _result.setName(_tmpName);
            final String _tmpStreet1;
            _tmpStreet1 = _cursor.getString(_cursorIndexOfStreet1);
            _result.setStreet1(_tmpStreet1);
            final String _tmpStreet2;
            _tmpStreet2 = _cursor.getString(_cursorIndexOfStreet2);
            _result.setStreet2(_tmpStreet2);
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            _result.setCity(_tmpCity);
            final String _tmpCityCode;
            _tmpCityCode = _cursor.getString(_cursorIndexOfCityCode);
            _result.setCityCode(_tmpCityCode);
            final String _tmpStateCode;
            _tmpStateCode = _cursor.getString(_cursorIndexOfStateCode);
            _result.setStateCode(_tmpStateCode);
            final String _tmpPostalCode;
            _tmpPostalCode = _cursor.getString(_cursorIndexOfPostalCode);
            _result.setPostalCode(_tmpPostalCode);
            final String _tmpCountryCode;
            _tmpCountryCode = _cursor.getString(_cursorIndexOfCountryCode);
            _result.setCountryCode(_tmpCountryCode);
            final String _tmpDistrict;
            _tmpDistrict = _cursor.getString(_cursorIndexOfDistrict);
            _result.setDistrict(_tmpDistrict);
            final String _tmpCountryName;
            _tmpCountryName = _cursor.getString(_cursorIndexOfCountryName);
            _result.setCountryName(_tmpCountryName);
            final String _tmpRegionName;
            _tmpRegionName = _cursor.getString(_cursorIndexOfRegionName);
            _result.setRegionName(_tmpRegionName);
            final String _tmpTimeZoneRegionName;
            _tmpTimeZoneRegionName = _cursor.getString(_cursorIndexOfTimeZoneRegionName);
            _result.setTimeZoneRegionName(_tmpTimeZoneRegionName);
            final String _tmpWeatherZone;
            _tmpWeatherZone = _cursor.getString(_cursorIndexOfWeatherZone);
            _result.setWeatherZone(_tmpWeatherZone);
            final String _tmpLocalTime;
            _tmpLocalTime = _cursor.getString(_cursorIndexOfLocalTime);
            _result.setLocalTime(_tmpLocalTime);
            final double _tmpUtcOffsetHours;
            _tmpUtcOffsetHours = _cursor.getDouble(_cursorIndexOfUtcOffsetHours);
            _result.setUtcOffsetHours(_tmpUtcOffsetHours);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            _result.setLatitude(_tmpLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            _result.setLongitude(_tmpLongitude);
            final int _tmpElevationFeet;
            _tmpElevationFeet = _cursor.getInt(_cursorIndexOfElevationFeet);
            _result.setElevationFeet(_tmpElevationFeet);
            final int _tmpClassification;
            _tmpClassification = _cursor.getInt(_cursorIndexOfClassification);
            _result.setClassification(_tmpClassification);
            final boolean _tmpActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfActive);
            _tmpActive = _tmp != 0;
            _result.setActive(_tmpActive);
            final String _tmpDateFrom;
            _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
            _result.setDateFrom(_tmpDateFrom);
            final String _tmpDateTo;
            _tmpDateTo = _cursor.getString(_cursorIndexOfDateTo);
            _result.setDateTo(_tmpDateTo);
            final String _tmpWeatherUrl;
            _tmpWeatherUrl = _cursor.getString(_cursorIndexOfWeatherUrl);
            _result.setWeatherUrl(_tmpWeatherUrl);
            final String _tmpDelayIndexUrl;
            _tmpDelayIndexUrl = _cursor.getString(_cursorIndexOfDelayIndexUrl);
            _result.setDelayIndexUrl(_tmpDelayIndexUrl);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
