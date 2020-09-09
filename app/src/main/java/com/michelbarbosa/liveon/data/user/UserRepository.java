package com.michelbarbosa.liveon.data.user;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Delete;

import com.michelbarbosa.liveon.data.LiveOnDatabase;
import com.michelbarbosa.liveon.data.entities.OrderEntity;
import com.michelbarbosa.liveon.data.entities.StatusEntity;
import com.michelbarbosa.liveon.data.entities.UserEntity;
import com.michelbarbosa.liveon.domain.Order;

import java.util.List;

class UserRepository {

    private MutableLiveData<UserEntity> mUserResult = new MutableLiveData<>();
    private LiveData<UserEntity> mUser;
    private MutableLiveData<List<OrderEntity>> mOrderListResult = new MutableLiveData<>();
    private LiveData<List<OrderEntity>> mOrderList;
    private MutableLiveData<List<StatusEntity>> mStatusListResult = new MutableLiveData<>();
    private LiveData<List<StatusEntity>> mStatusList;

    private UserDAO mDao;

    UserRepository(Application application) {
        LiveOnDatabase db;
        db = LiveOnDatabase.getDatabase(application);
        mDao = db.userDAO();
        mUser = mDao.getUserEntity();
        mOrderList = mDao.getOrderEntityList();
        mStatusList = mDao.getStatusEntityList();
    }

    /**
     * INSERT - UserEntity
     */
    void insertUserEntity(UserEntity userEntity){
        InsertUserEntityAsyncTask task = new InsertUserEntityAsyncTask(mDao);
        task.execute(userEntity);
    }

    private static class InsertUserEntityAsyncTask extends AsyncTask<UserEntity, Void, Void> {
        private UserDAO asyncTaskDao;
        InsertUserEntityAsyncTask(UserDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }
        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            asyncTaskDao.insertUserEntity(userEntities[0]);
            return null;
        }
    }

    /**
     * INSERT - OrderEntity
     */
    void insertOrderEntity(OrderEntity orderEntity){
        InsertOrderEntityAsyncTask task = new InsertOrderEntityAsyncTask(mDao);
        task.execute(orderEntity);
    }

    private static class InsertOrderEntityAsyncTask extends AsyncTask<OrderEntity, Void, Void> {
        private UserDAO asyncTaskDao;
        InsertOrderEntityAsyncTask(UserDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }
        @Override
        protected Void doInBackground(OrderEntity... orderEntities) {
            asyncTaskDao.insertOrderEntity(orderEntities[0]);
            return null;
        }
    }

    /**
     * INSERT - List<StatusEntity>
     */
    void insertStatusEntity(List<StatusEntity> statusEntityList){
        InsertStatusEntityAsyncTask task = new InsertStatusEntityAsyncTask(mDao);
        task.execute(statusEntityList);
    }

    private static class InsertStatusEntityAsyncTask extends AsyncTask<List<StatusEntity>, Void, Void> {
        private UserDAO asyncTaskDao;
        InsertStatusEntityAsyncTask(UserDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }
        @Override
        protected Void doInBackground(List<StatusEntity>... lists) {
            asyncTaskDao.insertStatusEntityList(lists[0]);
            return null;
        }
    }

    /**
     * SELECT - User
     */

    LiveData<UserEntity> getmUser(){
        SelectUserAsyncTask task = new SelectUserAsyncTask(mDao);
        task.delegate = this;
        task.execute();
        return mUser;
    }

    MutableLiveData<UserEntity> getmUserResult(){
        SelectUserAsyncTask task = new SelectUserAsyncTask(mDao);
        task.delegate = this;
        task.execute();
        return mUserResult;
    }

    private void asyncFinishedUser(UserEntity userEntity){
        mUserResult.postValue(userEntity);
    }

    private static class SelectUserAsyncTask extends AsyncTask<Void, Void, UserEntity> {
        private UserDAO asyncTaskDao;
        private UserRepository delegate = null;

        SelectUserAsyncTask(UserDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }

        @Override
        protected UserEntity doInBackground(Void... voids) {
            return asyncTaskDao.findUserEntity();
        }

        @Override
        protected void onPostExecute(UserEntity userEntity) {
            delegate.asyncFinishedUser(userEntity);
        }
    }

    /**
     * SELECT - List<OrderEntity>
     */

    LiveData<List<OrderEntity>> getmOrderList(){
        SelectOrderListAsyncTask task = new SelectOrderListAsyncTask(mDao);
        task.delegate = this;
        task.execute();
        return mOrderList;
    }

    MutableLiveData<List<OrderEntity>> getmOrderListResult(){
        SelectOrderListAsyncTask task = new SelectOrderListAsyncTask(mDao);
        task.delegate = this;
        task.execute();
        return mOrderListResult;
    }

    private void asyncFinishedOrderList(List<OrderEntity> orderEntityList){
        mOrderListResult.postValue(orderEntityList);
    }

    private static class SelectOrderListAsyncTask extends AsyncTask<Void, Void, List<OrderEntity>> {
        private UserDAO asyncTaskDao;
        private UserRepository delegate = null;

        SelectOrderListAsyncTask(UserDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }

        @Override
        protected List<OrderEntity> doInBackground(Void... voids) {
            return asyncTaskDao.findOrderEntityList();
        }

        @Override
        protected void onPostExecute(List<OrderEntity> orderEntityList) {
            delegate.asyncFinishedOrderList(orderEntityList);
        }
    }

    /**
     * SELECT - List<StatusEntity>
     */

    LiveData<List<StatusEntity>> getmStatusList(){
        SelectStatusListAsyncTask task = new SelectStatusListAsyncTask(mDao);
        task.delegate = this;
        task.execute();
        return mStatusList;
    }

    MutableLiveData<List<StatusEntity>> getmStatusListResult(){
        SelectStatusListAsyncTask task = new SelectStatusListAsyncTask(mDao);
        task.delegate = this;
        task.execute();
        return mStatusListResult;
    }

    private void asyncFinishedStatusList(List<StatusEntity> statusEntityList){
        mStatusListResult.postValue(statusEntityList);
    }

    private static class SelectStatusListAsyncTask extends AsyncTask<Void, Void, List<StatusEntity>> {
        private UserDAO asyncTaskDao;
        private UserRepository delegate = null;

        SelectStatusListAsyncTask(UserDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }

        @Override
        protected List<StatusEntity> doInBackground(Void... voids) {
            return asyncTaskDao.findStatusEntityList();
        }

        @Override
        protected void onPostExecute(List<StatusEntity> statusEntityList) {
            delegate.asyncFinishedStatusList(statusEntityList);
        }
    }

    /**
     * DELETE - (CASCADE) User, Order, Status
     */
    void deleteUser() {
        DeleteUserAsyncTask task = new DeleteUserAsyncTask(mDao);
        task.execute();
    }
    private static class DeleteUserAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDAO asyncTaskDao;
        DeleteUserAsyncTask(UserDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            asyncTaskDao.deleteUser();
            return null;
        }
    }

    void deleteAllOrder() {
        DeleteAllOrderAsyncTask task = new DeleteAllOrderAsyncTask(mDao);
        task.execute();
    }
    private static class DeleteAllOrderAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDAO asyncTaskDao;
        DeleteAllOrderAsyncTask(UserDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            asyncTaskDao.deleteAllOrder();
            return null;
        }
    }

    void deleteAllStatus() {
        DeleteAllStatusAsyncTask task = new DeleteAllStatusAsyncTask(mDao);
        task.execute();
    }

    private static class DeleteAllStatusAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDAO asyncTaskDao;
        DeleteAllStatusAsyncTask(UserDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            asyncTaskDao.deleteAllStatus();
            return null;
        }
    }

    /**
     * UPDATE - ORDER_SUBMODEL_NAME
     */
    void updateOrderSubmodelName(OrderEntity orderEntity) {
        UpdateOrderSubmodelname task = new UpdateOrderSubmodelname(mDao);
        task.execute(orderEntity);
    }
    private static class UpdateOrderSubmodelname extends AsyncTask<OrderEntity, Void, Void> {
        private UserDAO asyncTaskDao;
        UpdateOrderSubmodelname(UserDAO asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }
        @Override
        protected Void doInBackground(OrderEntity... orderEntities) {
            asyncTaskDao.updateOrderSubmodelName(orderEntities[0].getOrderId(),
                    orderEntities[0].getSubmodel_name());
            return null;
        }
    }

}
