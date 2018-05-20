package com.example.android.scheduler_app.databinding;
import com.example.android.scheduler_app.R;
import com.example.android.scheduler_app.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class FlightStatusItemBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textView2, 4);
        sViewsWithIds.put(R.id.textView3, 5);
        sViewsWithIds.put(R.id.textView4, 6);
        sViewsWithIds.put(R.id.textView5, 7);
        sViewsWithIds.put(R.id.textView9, 8);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    public final android.widget.TextView textView10;
    @NonNull
    public final android.widget.TextView textView2;
    @NonNull
    public final android.widget.TextView textView3;
    @NonNull
    public final android.widget.TextView textView4;
    @NonNull
    public final android.widget.TextView textView5;
    @NonNull
    public final android.widget.TextView textView6;
    @NonNull
    public final android.widget.TextView textView7;
    @NonNull
    public final android.widget.TextView textView9;
    // variables
    @Nullable
    private com.example.android.scheduler_app.ui.FlightStatusClickCallback mCallback;
    @Nullable
    private com.example.android.scheduler_app.db.entity.schedule_entites.FlightStatus mFlightStatus;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FlightStatusItemBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textView10 = (android.widget.TextView) bindings[3];
        this.textView10.setTag(null);
        this.textView2 = (android.widget.TextView) bindings[4];
        this.textView3 = (android.widget.TextView) bindings[5];
        this.textView4 = (android.widget.TextView) bindings[6];
        this.textView5 = (android.widget.TextView) bindings[7];
        this.textView6 = (android.widget.TextView) bindings[1];
        this.textView6.setTag(null);
        this.textView7 = (android.widget.TextView) bindings[2];
        this.textView7.setTag(null);
        this.textView9 = (android.widget.TextView) bindings[8];
        setRootTag(root);
        // listeners
        mCallback1 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.callback == variableId) {
            setCallback((com.example.android.scheduler_app.ui.FlightStatusClickCallback) variable);
        }
        else if (BR.flightStatus == variableId) {
            setFlightStatus((com.example.android.scheduler_app.db.entity.schedule_entites.FlightStatus) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCallback(@Nullable com.example.android.scheduler_app.ui.FlightStatusClickCallback Callback) {
        this.mCallback = Callback;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.callback);
        super.requestRebind();
    }
    @Nullable
    public com.example.android.scheduler_app.ui.FlightStatusClickCallback getCallback() {
        return mCallback;
    }
    public void setFlightStatus(@Nullable com.example.android.scheduler_app.db.entity.schedule_entites.FlightStatus FlightStatus) {
        this.mFlightStatus = FlightStatus;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.flightStatus);
        super.requestRebind();
    }
    @Nullable
    public com.example.android.scheduler_app.db.entity.schedule_entites.FlightStatus getFlightStatus() {
        return mFlightStatus;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.android.scheduler_app.ui.FlightStatusClickCallback callback = mCallback;
        com.example.android.scheduler_app.db.entity.schedule_entites.FlightStatus flightStatus = mFlightStatus;
        java.lang.String flightStatusFlightNumber = null;
        java.lang.String flightStatusArrivalAirportFsCode = null;
        java.lang.String flightStatusDepartureAirportFsCode = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (flightStatus != null) {
                    // read flightStatus.flightNumber
                    flightStatusFlightNumber = flightStatus.getFlightNumber();
                    // read flightStatus.arrivalAirportFsCode
                    flightStatusArrivalAirportFsCode = flightStatus.getArrivalAirportFsCode();
                    // read flightStatus.departureAirportFsCode
                    flightStatusDepartureAirportFsCode = flightStatus.getDepartureAirportFsCode();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.textView10, flightStatusFlightNumber);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textView6, flightStatusDepartureAirportFsCode);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textView7, flightStatusArrivalAirportFsCode);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // callback
        com.example.android.scheduler_app.ui.FlightStatusClickCallback callback = mCallback;
        // flightStatus
        com.example.android.scheduler_app.db.entity.schedule_entites.FlightStatus flightStatus = mFlightStatus;
        // callback != null
        boolean callbackJavaLangObjectNull = false;



        callbackJavaLangObjectNull = (callback) != (null);
        if (callbackJavaLangObjectNull) {



            callback.onClick(flightStatus);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FlightStatusItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FlightStatusItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FlightStatusItemBinding>inflate(inflater, com.example.android.scheduler_app.R.layout.flight_status_item, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FlightStatusItemBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FlightStatusItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.android.scheduler_app.R.layout.flight_status_item, null, false), bindingComponent);
    }
    @NonNull
    public static FlightStatusItemBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FlightStatusItemBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/flight_status_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FlightStatusItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): callback
        flag 1 (0x2L): flightStatus
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}