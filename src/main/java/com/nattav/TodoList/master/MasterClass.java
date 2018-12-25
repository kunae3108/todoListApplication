package com.nattav.TodoList.master;

public class MasterClass
{

	public enum TASK_STATUS
	{

		PENDING("PEND", "Pending");

		private String statusCd 	= "";
		private String statusName 	= "";

		TASK_STATUS(String _statusCd, String _statusName)
		{
			statusCd 	= _statusCd;
			statusName 	= _statusName;
		}

		public String getStatusCd()
		{
			return statusCd;
		}

		public String getStatusName()
		{
			return statusName;
		}

	}
	
	public static boolean isExistingTaskStatus(String _statusCd)
    {
        for(TASK_STATUS rc : TASK_STATUS.values())
        {
            if(rc.getStatusCd().equals(_statusCd))
            {
                return true;
            }
        }
        
        return false;
    }



}
