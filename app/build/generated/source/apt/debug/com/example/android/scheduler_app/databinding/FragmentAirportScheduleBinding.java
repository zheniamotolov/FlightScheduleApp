package com.example.android.scheduler_app.databinding;
import com.example.android.scheduler_app.R;
import com.example.android.scheduler_app.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class FragmentAirportScheduleBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(5);
        sIncludes.setIncludes(0, 
            new String[] {"airport_item"},
            new int[] {3},
            new int[] {R.layout.airport_item});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.flight_list_wrapper, 4);
    }
    // views
    @NonNull
    public final android.support.v7.widget.RecyclerView flightList;
    @NonNull
    public final android.widget.FrameLayout flightListWrapper;
    @NonNull
    public final android.widget.TextView loadingTv;
    @Nullable
    private final com.example.android.scheduler_app.databinding.AirportItemBinding mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView01;
    // variables
    @Nullable
    private boolean mIsLoading;
    @Nullable
    private com.example.android.scheduler_app.viewmodel.AirportScheduleViewModel mAirportScheduleViewModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentAirportScheduleBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.flightList = (android.support.v7.widget.RecyclerView) bindings[2];
        this.flightList.setTag(null);
        this.flightListWrapper = (android.widget.FrameLayout) bindings[4];
        this.loadingTv = (android.widget.TextView) bindings[1];
        this.loadingTv.setTag(null);
        this.mboundView0 = (com.example.android.scheduler_app.databinding.AirportItemBinding) bindings[3];
        setContainedBinding(this.mboundView0);
        this.mboundView01 = (android.widget.LinearLayout) bindings[0];
        this.mboundView01.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        mboundView0.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView0.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.isLoading == variableId) {
            setIsLoading((boolean) variable);
        }
        else if (BR.airportScheduleViewModel == variableId) {
            setAirportScheduleViewModel((com.example.android.scheduler_app.viewmodel.AirportScheduleViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setIsLoading(boolean IsLoading) {
        this.mIsLoading = IsLoading;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.isLoading);
        super.requestRebind();
    }
    public boolean getIsLoading() {
        return mIsLoading;
    }
    public void setAirportScheduleViewModel(@Nullable com.example.android.scheduler_app.viewmodel.AirportScheduleViewModel AirportScheduleViewModel) {
        this.mAirportScheduleViewModel = AirportScheduleViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.airportScheduleViewModel);
        super.requestRebind();
    }
    @Nullable
    public com.example.android.scheduler_app.viewmodel.AirportScheduleViewModel getAirportScheduleViewModel() {
        return mAirportScheduleViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeAirportScheduleViewModelAirport((android.databinding.ObservableField<com.example.android.scheduler_app.db.entity.Airport>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeAirportScheduleViewModelAirport(android.databinding.ObservableField<com.example.android.scheduler_app.db.entity.Airport> AirportScheduleViewModelAirport, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        boolean isLoading = mIsLoading;
        com.example.android.scheduler_app.viewmodel.AirportScheduleViewModel airportScheduleViewModel = mAirportScheduleViewModel;
        com.example.android.scheduler_app.db.entity.Airport airportScheduleViewModelAirportGet = null;
        android.databinding.ObservableField<com.example.android.scheduler_app.db.entity.Airport> airportScheduleViewModelAirport = null;
        boolean IsLoading1 = false;

        if ((dirtyFlags & 0xaL) != 0) {



                // read !isLoading
                IsLoading1 = !isLoading;
        }
        if ((dirtyFlags & 0xdL) != 0) {



                if (airportScheduleViewModel != null) {
                    // read airportScheduleViewModel.airport
                    airportScheduleViewModelAirport = airportScheduleViewModel.airport;
                }
                updateRegistration(0, airportScheduleViewModelAirport);


                if (airportScheduleViewModelAirport != null) {
                    // read airportScheduleViewModel.airport.get()
                    airportScheduleViewModelAirportGet = airportScheduleViewModelAirport.get();
                }
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            com.example.android.scheduler_app.ui.BindingAdapters.showHide(this.flightList, IsLoading1);
            com.example.android.scheduler_app.ui.BindingAdapters.showHide(this.loadingTv, isLoading);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.mboundView0.setAirport(airportScheduleViewModelAirportGet);
        }
        executeBindingsOn(mboundView0);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentAirportScheduleBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentAirportScheduleBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentAirportScheduleBinding>inflate(inflater, com.example.android.scheduler_app.R.layout.fragment_airport_schedule, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentAirportScheduleBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentAirportScheduleBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.android.scheduler_app.R.layout.fragment_airport_schedule, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentAirportScheduleBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentAirportScheduleBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_airport_schedule_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentAirportScheduleBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): airportScheduleViewModel.airport
        flag 1 (0x2L): isLoading
        flag 2 (0x3L): airportScheduleViewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}