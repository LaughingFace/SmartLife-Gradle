package com.laughingface.smartlife.microwash.devicecontroler.device.infc;


import com.laughingface.smartlife.microwash.devicecontroler.device.Device;

public interface DeviceStateListener {

	public abstract void onLine(Device device);

	public abstract void offLine();

}
