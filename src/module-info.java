/**
 * 
 */
/**
 * 
 */
module Chat_app {
	requires java.rmi;
	requires java.desktop;
	exports server to java.rmi;
	exports authentication.server to java.rmi;
}