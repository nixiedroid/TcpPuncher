package com.nixiedroid.data.builders;

import com.nixiedroid.data.model.Parcel;
import com.nixiedroid.data.model.ParcelType;

public interface ParcelFactory {

    Parcel make(ParcelType type);
}
