package com.philihp.weblabora.model.building;

import static com.philihp.weblabora.model.TerrainTypeEnum.COAST;
import static com.philihp.weblabora.model.TerrainTypeEnum.MOUNTAIN;
import static com.philihp.weblabora.model.TerrainTypeEnum.HILLSIDE;
import static com.philihp.weblabora.model.TerrainTypeEnum.PLAINS;

import java.util.EnumSet;
import java.util.Set;

import com.philihp.weblabora.model.Board;
import com.philihp.weblabora.model.BuildCost;
import com.philihp.weblabora.model.Player;
import com.philihp.weblabora.model.SettlementRound;
import com.philihp.weblabora.model.TerrainTypeEnum;
import com.philihp.weblabora.model.UsageParam;
import com.philihp.weblabora.model.Wheel;

public class Castle extends Building {

	public Castle() {
		super("G28", SettlementRound.C, 1, "Castle", BuildCost.is().wood(6).stone(5), 7, 15,
				EnumSet.of(HILLSIDE, MOUNTAIN), false);
	}

	@Override
	public void use(Board board, UsageParam input) {
		//Player player = board.getPlayer(board.getActivePlayer());
		//TODO: castle build settlement
	}
}
