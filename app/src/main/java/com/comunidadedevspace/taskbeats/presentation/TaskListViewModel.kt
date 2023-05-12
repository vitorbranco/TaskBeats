package com.comunidadedevspace.taskbeats.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comunidadedevspace.taskbeats.TaskBeatsApplication
import com.comunidadedevspace.taskbeats.data.Task
import com.comunidadedevspace.taskbeats.data.TaskDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskListViewModel(
    private val taskDao: TaskDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
    ): ViewModel() {

    val taskListLiveData: LiveData<List<Task>> = taskDao.getAll()

    fun execute(taskAction: TaskAction){
        when (taskAction.actionType) {
            ActionType.DELETE.name -> deleteById(taskAction.task!!.id)
            ActionType.DELETE_ALL.name -> deleteAll()
            ActionType.CREATE.name -> insertIntoDatabase(taskAction.task!!)
            ActionType.UPDATE.name -> updateIntoDatabase(taskAction.task!!)
        }
    }

    private fun insertIntoDatabase(task: Task) {
        viewModelScope.launch(dispatcher) {
            taskDao.insert(task)
        }
    }

    private fun updateIntoDatabase(task: Task) {
        viewModelScope.launch(dispatcher) {
            taskDao.update(task)
        }
    }

    private fun deleteById(id: Int) {
        viewModelScope.launch(dispatcher) {
            taskDao.deleteById(id)

        }
    }
    private fun deleteAll() {
        viewModelScope.launch(dispatcher) {
            taskDao.deleteAll()
        }
    }

    companion object {
        fun create(application: Application): TaskListViewModel {
            val databaseInstance = (application as TaskBeatsApplication).getAppDatabase()
            val dao = databaseInstance.taskDao()
            return TaskListViewModel(dao)
        }
    }
}