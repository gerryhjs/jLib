package dataStructure;

import javax.management.RuntimeErrorException;

public class OutOfSpaceException{ 
	public OutOfSpaceException() throws RuntimeErrorException
	{
		throw new RuntimeErrorException(null);
	}
	public OutOfSpaceException(String msg) throws RuntimeErrorException
	{
		throw new RuntimeErrorException(null, msg);
	}
}
