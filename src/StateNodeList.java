
public interface StateNodeList {
	/**
	 * return if the option node list is a cut-off list
	 * @return true if it is cut off, else false
	 */
	public boolean isCutOff();
	
	/**
	 * print list given the first number
	 */
	public void printList();
	
	/**
	 * setter for isCutOff flag
	 * @param isCutOff
	 */
	public void setCutOff(boolean isCutOff);

	public int length();
}
