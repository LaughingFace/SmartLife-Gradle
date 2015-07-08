package com.laughingface.smartlife.microwash.devicecontroler.model.infc;

import com.laughingface.smartlife.microwash.devicecontroler.model.Model;
import com.laughingface.smartlife.microwash.devicecontroler.model.ModelAngel;

public interface ModelStateListener {

	public abstract void onModelStart(Model model, ModelAngel.StartType type);

	public abstract void onProcessing(Model model);

	public abstract void onFinish(Model model);

	public abstract void onInterupt(Model model);

	public abstract void faillOnStart(Model model, ModelAngel.StartFaillType type);

}
