package com.michelbarbosa.liveon.data.orders;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.michelbarbosa.liveon.data.LiveOnDatabase;
import com.michelbarbosa.liveon.data.entities.OrderVehicleEntity;

import java.util.List;

class VehicleRepository {

    private MutableLiveData<List<OrderVehicleEntity>> mOrderVListResult = new MutableLiveData<>();
    private LiveData<List<OrderVehicleEntity>> mOrderVList;

    private VehicleDAO mDao;

    VehicleRepository(Application application) {
        LiveOnDatabase db;
        db = LiveOnDatabase.getDatabase(application);
        mDao = db.vehicleDAO();
        mOrderVList = mDao.getOrderVehicleEntityList();
    }

    /**
     * INSERT - List<OrderVehicleEntity>
     */
    void insertOrderVEntityList(List<OrderVehicleEntity> orderVehicleEntityList) {
        InsertOrderEntityListAsyncTask task = new InsertOrderEntityListAsyncTask(mDao);
        task.execute(orderVehicleEntityList);
    }

    private static class InsertOrderEntityListAsyncTask extends AsyncTask<List<OrderVehicleEntity>, Void, Void> {
        private VehicleDAO asyncTaskDao;

        InsertOrderEntityListAsyncTask(VehicleDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }

        @Override
        protected Void doInBackground(List<OrderVehicleEntity>... lists) {
            asyncTaskDao.insertOrderVehicleEntity(lists[0]);
            return null;
        }
    }

    /**
     * SELECT - List<OrderVehicleEntity>
     **/

    LiveData<List<OrderVehicleEntity>> getmOrderVList() {
        SelectOrderVehicleListAsyncTask task = new SelectOrderVehicleListAsyncTask(mDao);
        task.delegate = this;
        task.execute();
        return mOrderVList;
    }

    MutableLiveData<List<OrderVehicleEntity>> getmOrderVListResult() {
        SelectOrderVehicleListAsyncTask task = new SelectOrderVehicleListAsyncTask(mDao);
        task.delegate = this;
        task.execute();
        return mOrderVListResult;
    }

    private void asyncFinishedOrderList(List<OrderVehicleEntity> orderVehicleEntityList) {
        mOrderVListResult.postValue(orderVehicleEntityList);
    }

    private static class SelectOrderVehicleListAsyncTask extends AsyncTask<Void, Void, List<OrderVehicleEntity>> {
        private VehicleDAO asyncTaskDao;
        private VehicleRepository delegate = null;
        SelectOrderVehicleListAsyncTask(VehicleDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }
        @Override
        protected List<OrderVehicleEntity> doInBackground(Void... voids) {
            return asyncTaskDao.findOrderVehicleEntityList();
        }
        @Override
        protected void onPostExecute(List<OrderVehicleEntity> orderVehicleEntityList) {
            delegate.asyncFinishedOrderList(orderVehicleEntityList);
        }
    }

}
